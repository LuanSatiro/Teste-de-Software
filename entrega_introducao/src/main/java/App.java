package application;

import org.json.JSONException;
import org.json.JSONObject;

public class App{
    public static void main(String  []  args){
        String json_str = "{\"userId\":1,\"id\":1,\"title\":\"Json in Java\",\"completed\":true}";
    
        JSONObject my_obj = new JSONObject(json_str);
        int userId = my_obj.getInt("userId");
        String title = my_obj.getString("title");
        boolean completed = my_obj.getBoolean("completed");

        System.out.println(userId);
        System.out.println(title);
        System.out.println(completed);
    }
}
