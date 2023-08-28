package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import objects.rickAndMortyEpisodes.Infoepisode;
import objects.rickAndMortyEpisodes.Resultepisode;
import objects.rickAndMortyEpisodes.RootEpisode;
import org.json.JSONObject;
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

        main=om.readValue(ApiRequest.getRest(URL), RootEpisode.class);}
    @Test
    public void test1() throws JsonProcessingException {
        int i=0;
        do {
            ///deystvie
            for (Resultepisode result : main.results) {
                System.out.println(result.name + " - " + result.air_date + " :");
                System.out.println("");
                i++;
            }
            ///deystvie
            if(main.info.next==null){
                break;
            }else{
                main=om.readValue(ApiRequest.getRest(main.info.next), RootEpisode.class);
            }
        }while (true);
        System.out.println(i);
    }
    @Test
    public void test2() throws JsonProcessingException {
        Infoepisode info=om.readValue( new JSONObject(ApiRequest.getRest(URL)).getJSONObject("info").toString(),Infoepisode.class);
    }
}

