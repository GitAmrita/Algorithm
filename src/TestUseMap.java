import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by achowdhury on 6/1/2015.
 */
public class TestUseMap {

    public class City{
        public String CityName;
        public Boolean Visited;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            City city = (City) o;

            if (!CityName.equals(city.CityName)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return CityName.hashCode();
        }

        public City(String name, Boolean visited){
            CityName = name;
            Visited = visited;
        }
    }

    public void CreateStates(){
        Map<City,List<City>> California = new HashMap<City, List<City>>();
        //create the city object
        City s1=new City("SanMateo",true);
        City s2=new City("Redwood",false);
        City s3=new City("Burlingame",false);
        City s4=new City("MountainView",true);

        //insert into the state map
        California.put(s1, Arrays.asList(s2,s3));
        California.put(s2, Arrays.asList(s1));
        California.put(s3, Arrays.asList(s1));
        California.put(s4, null);
//*******************************************should work*****************************************
        List<City> getS1=California.get(s1);
        for(City c : getS1){
            System.out.println("Neighboring city : "+ c.CityName + " is visited : " + c.Visited);
        }
//***********************************end of should work*****************************************
        GetCity(California);


    }

    public void GetCity(Map<City,List<City>> California){
        City s1=new City("SanMateo",true);
        List<City> getS1=California.get(s1);
        for(City c : getS1){
            System.out.println("Neighboring city : "+ c.CityName + " is visited : " + c.Visited);
        }
    }

    //*******************************************************************************************************************

    public void CreateNoName(){
        Map<Integer,List<Integer>> nos = new HashMap<Integer,List<Integer>>();
        //insert into the state map
        nos.put(1, Arrays.asList(2, 0));
        nos.put(5, Arrays.asList(6, 4));
//*******************************************should work*****************************************
        List<Integer> getS1=nos.get(1);
        for(Integer c : getS1){
            System.out.println(c);
        }
//***********************************end of should work*****************************************
        GetNoName(nos);


    }

    public void GetNoName(Map<Integer,List<Integer>>nos){
        List<Integer> getS1=nos.get(1);
        for(Integer c : getS1){
            System.out.println(c);
        }
    }
}
