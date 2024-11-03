package org.example.LLDSystemDesigns.DesignBookMyShow;

import org.example.LLDSystemDesigns.DesignBookMyShow.Enums.City;
import org.example.LLDSystemDesigns.DesignBookMyShow.Enums.SeatCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    MovieController movieController;
    TheaterController theaterController;

    BookMyShow(){
        movieController = new MovieController();
        theaterController = new TheaterController();
    }

    private void initialize() {
        createMovies();
        createTheater();

    }

    public static void main(String[] args){
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();

        bookMyShow.createBooking(City.DELHI, "venom");
        bookMyShow.createBooking(City.DELHI, "venom");
        //bookMyShow.createBooking(City.NOIDA, "venom");
    }

    private void createBooking(City city, String movieName) {
        List<Movie> movies = movieController.getMoviesByCity(city);
        Movie intrestedMovie = null;
        for(Movie movie: movies){
            if(movie.getMovieName().equals(movieName)){
                intrestedMovie = movie;
            }
        }

     Map<Theater, List<Show>> showTheaterWise =  theaterController.getAllShows(intrestedMovie, city);

     Map.Entry<Theater, List<Show>> entry = showTheaterWise.entrySet().iterator().next();
     List<Show> runningShow = entry.getValue();
     Show interstedShow = runningShow.get(0);

     //select seat;

        int seatNumber  = 30;
        List<Integer> bookedSeat = interstedShow.getBookedSeat();
        if(!bookedSeat.contains(seatNumber)){
            bookedSeat.add(seatNumber);

            //Start payment
            Booking booking = new Booking();
            List<Seat> myBookingSeats = new ArrayList<>();
            for(Seat screenSeat: interstedShow.getScreen().getSeats()){
                if(screenSeat.getSeatId() == seatNumber){
                    myBookingSeats.add(screenSeat);
                }
            }
            booking.setBookingSeat(myBookingSeats);
            booking.setShow(interstedShow);
           // booking.setPayment(new Payment().setStatus("COMPLETE"));
        }else{
            System.out.println("Seat already booked, try again");
            return;
        }
        System.out.println("Booking Successfully!");

    }


    private void  createMovies(){
        Movie venom = new Movie();
        venom.setMovieName("venom");
        venom.setDuration(110);
        venom.setGenre("sci-fi, Adventures, Action");
        venom.setMovieId(4564);

        Movie wild_robot = new Movie();
        wild_robot.setMovieName("wild robot");
        wild_robot.setDuration(101);
        wild_robot.setGenre("Adventures, Animation, Family");
        wild_robot.setMovieId(87878);

        movieController.addMovies(City.DELHI, venom);
        movieController.addMovies(City.DELHI, wild_robot);
        movieController.addMovies(City.NOIDA, venom);
        movieController.addMovies(City.NOIDA, wild_robot);
    }
    private void createTheater(){

        Movie venomMovie = movieController.getMoviesByName("venom");
        Movie wildRobotMovie = movieController.getMoviesByName("wild robot");

        Theater pvrTheater = new Theater();
        pvrTheater.setAddress("Delhi, Saket");
        pvrTheater.setCity(City.DELHI);
        pvrTheater.setScreens(createScreen());
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShow(12,pvrTheater.getScreens().get(0), venomMovie, 8);
        Show pvrEveningShow= createShow(12,pvrTheater.getScreens().get(1), wildRobotMovie, 17);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);

        pvrTheater.setShows(pvrShows);

        Theater inoxTheater = new Theater();
        inoxTheater.setAddress("Noida, wave city");
        inoxTheater.setCity(City.NOIDA);
        inoxTheater.setScreens(createScreen());
        List<Show> inoxShow = new ArrayList<>();
        Show inoxMorningShow = createShow(12,pvrTheater.getScreens().get(0), wildRobotMovie, 8);
        Show inoxEveningShow = createShow(12,pvrTheater.getScreens().get(1), venomMovie, 17);
        inoxShow.add(inoxMorningShow);
        inoxShow.add(inoxEveningShow);
        inoxTheater.setShows(inoxShow);

        theaterController.addTheater(City.DELHI, pvrTheater);
        theaterController.addTheater(City.NOIDA, inoxTheater);

    }

    private Show createShow(int showId, Screen screen, Movie movie, int showStartTime) {
        Show show = new Show();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setShowStartTime(showStartTime);
        return show;
    }


    private List<Screen> createScreen() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenId(1234);
        screen1.setSeats(createSeat(98));
        screen1.setSize(250);
        screens.add(screen1);
        Screen screen2 = new Screen();
        screen2.setScreenId(1235);
        screen2.setSeats(createSeat(90));
        screen2.setSize(200);
        screens.add(screen2);

        return screens;
    }

    private List<Seat> createSeat(int n) {
        List<Seat> seats = new ArrayList<>();
        String [] row = {"A","B","C","D","F","G","H","J","K","L"};
        for(int i=0; i<n; i++){
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setRow(row[n%10]);
            if(i<=25){
              seat.setSeatCategory(SeatCategory.GOLD);
              seat.setPrice(250);
            }else if(i > 25 && i<=70){
                seat.setSeatCategory(SeatCategory.DIAMOND);
                seat.setPrice(350);
            }else {
                seat.setSeatCategory(SeatCategory.PLATINUM);
                seat.setPrice(450);
            }
            seats.add(seat);
        }
        return seats;
    }

}
