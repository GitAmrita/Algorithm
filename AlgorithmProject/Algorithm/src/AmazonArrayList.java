import java.util.*;
import java.util.LinkedList;

/**
 * Created by achowdhury on 7/2/2015.
 */

/*******************************************Summary******************************
 * 1.I am creating the collection of movies in a hashmap with the movieID as the key and the list of similar movies as the value
 * 2.I am trying to find all connected components of the movie graph. For a given start node I do a BFS search on the movie graph
 * gathering all the nodes (movies) I come across and add it to recommendations list. To make sure I do not have duplicates in my
 * recommendations list ,I have added a boolean explored to the movie class which will keep track if that particular node is traversed already.
 * 3.Once I have all the degrees of similar movies to the movie in question, I sort the list per descending value of rating
 * 4.I grab top n recommendations from the sorted similar movie list
 * ******************************************************************************
 * *****************************Time complexity**********************************
 * V= number of vertices E= no of strongly connected edges
 * Time complexity for enqueue and de queue for n connected vertices = O(V)
 * Time complexity for looping through all edges incident on a vertex = O(E)
 * Time complexity for searching a particular node in the graph = O(1)
 * Time complexity for sorting recommendation = O(ELogE)
 * Total time complexity of the operation = O(V + E) + O(ELogE)
 * ********************************************************************************
 * * *****************************Space complexity**********************************
 * Space complexity for queue = O(V)
 * Space complexity for arrayList = O(E)
 * Total space complexity = O(V+E)
 * *********************************************************************************
 * *****************************************Note*************************************
 * It is better to use interface List and implement it as arrayList or any other data structure
 * that implements List interface. The reason being if down the line we want to
 * use some other data structure, we will have to change just one line of code while
 * implementing the interface vs changing it all all places.
 * *********************************************************************************
 */
public class AmazonArrayList {
    //keeps a list of all the movies in key value pair
    public Map<Integer, Movie> movies = new HashMap<Integer, Movie>();

    public class Movie {
        private  int movieId;
        private  float rating;
        private boolean explored;
        private ArrayList<Movie> similarMovies;

        public Movie(int movieId, float rating) {
            this.movieId = movieId;
            this.rating = rating;
            this.explored = false;
            similarMovies = new ArrayList<Movie>();
        }

        public int getId() {
            return movieId;
        }

        public float getRating() {
            return rating;
        }

        public boolean getExplored() {
            return explored;
        }

        public void setExplored(boolean explored) {
            this.explored = explored;
        }

        public void addSimilarMovie(Movie movie) {
            similarMovies.add(movie);
        }

        public List<Movie> getSimilarMovies() {
            return similarMovies;
        }
    }

    //Depicting the given graph
    public void PopulateMovieList(){
        Movie m1 = new Movie(1,1.2f);
        Movie m2 = new Movie(2,2.4f);
        Movie m3 = new Movie(3,3.6f);
        Movie m4 = new Movie(4,4.8f);
        m1.addSimilarMovie(m2);
        m1.addSimilarMovie(m3);
        m2.addSimilarMovie(m1);
        m2.addSimilarMovie(m4);
        m3.addSimilarMovie(m1);
        m3.addSimilarMovie(m4);
        m4.addSimilarMovie(m2);
        m4.addSimilarMovie(m3);
        movies.put(m1.getId(),m1);
        movies.put(m2.getId(),m2);
        movies.put(m3.getId(),m3);
        movies.put(m4.getId(),m4);
        List<Movie>recommendedMovies= getMovieRecommendations(m1,4);
        PrintRecommendedMovies(recommendedMovies);
    }

    public void PrintRecommendedMovies(List<Movie>movies){
        if(movies == null){
            System.out.println("No such movie exists in the database");
            return;
        }
        System.out.println("Recommendations are :");
        for(int i = 0 ; i < movies.size() ; i++){
            System.out.println("Movie Name : " + movies.get(i).getId() + " Movie Rating : " + movies.get(i).getRating());
        }
        return;
    }

    public List<Movie> getMovieRecommendations(Movie m, int topRecommendation){
        List<Movie> allRecommendations = new ArrayList<Movie>();
        List<Movie> recommendedMovies = new ArrayList<Movie>();
        java.util.Queue<Movie> q = new LinkedList<Movie>();
        if(movies.get(m.getId()) == null)
            return null;
        q.add(m);
        m.setExplored(true);
        while(! q.isEmpty()){
            Movie root = q.poll();
            List<Movie> similarMovies = movies.get(root.getId()).getSimilarMovies();
            for(Movie sm : similarMovies){
                if(! sm.getExplored()){
                    sm.setExplored(true);
                    allRecommendations.add(sm);
                    q.add(sm);
                }
            }
        }
        Collections.sort(allRecommendations, new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return (m2.getRating() > m1.getRating()) ? 1 : -1;
            }
        });
        for(int i = 0 ; i < allRecommendations.size() ;  i++){
            if(i == topRecommendation)
                break;
            recommendedMovies.add(allRecommendations.get(i));
        }
        if(topRecommendation > allRecommendations.size())
            recommendedMovies.add(m);
        return  recommendedMovies;
    }
}
