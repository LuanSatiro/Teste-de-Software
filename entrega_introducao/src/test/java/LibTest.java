package application;


import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class LibTest{
    @Test
    public void verficarJsonTest(){
        String json_str = "{\"userId\":1,\"id\":1,\"title\":\"Json in Java\",\"completed\":true}";
    
        JSONObject my_obj = new JSONObject(json_str);
        int userId = my_obj.getInt("userId");
        String title = my_obj.getString("title");
        boolean completed = my_obj.getBoolean("completed");

        assertEquals(1,userId);
        assertEquals("Json in Java",title);
        assertEquals(true,completed);
    }
    @Test
    public void modificarJsonTest(){
        JSONObject my_obj = new JSONObject();
        my_obj.put("titulo", "Godzilla x King Kong: a estocada mortal");
        my_obj.put("ano", 2012);
        my_obj.put("genero", "Ação");
        String titulo = my_obj.getString("titulo");
        int ano = my_obj.getInt("ano");
        String genero = my_obj.getString("genero");
        assertEquals("Godzilla x King Kong: a estocada mortal", titulo);
        assertEquals(2012, ano);
        assertEquals("Ação", genero);
        

    }

}