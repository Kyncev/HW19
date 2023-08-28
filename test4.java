package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import objects.rickAndMortyEpisodes.Result;
import objects.rickAndMortyEpisodes.RootEpisode;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.ApiRequest;


public class test4 {
    static final String URL="https://rickandmortyapi.com/api/episode";
    static RootEpisode main;
    static ObjectMapper om=new ObjectMapper();
    @BeforeClass
    public static void bb() throws JsonProcessingException {

        //JSONObject mainApi = new JSONObject(ApiRequest.getRest(URL));
        //String rootsURL = mainApi.getString("roots");
        //ObjectMapper om = new ObjectMapper();
        //RootEpisode root = om.readValue(ApiRequest.getRest(rootsURL), RootEpisode.class);

        main=om.readValue(
                (      ApiRequest.getRest(URL)), RootEpisode.class);
    }
    @Test
    public void test1() throws JsonProcessingException {
        for (Result result : main.results) {
            System.out.println(result.name+" - "+result.air_date+" :");
            System.out.println("");
        }
    }

}