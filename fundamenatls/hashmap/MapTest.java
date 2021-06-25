import java.util.HashMap;
public class MapTest{
    public static void main (String[] args) {
        HashMap<String, String> trackList  = new HashMap<String, String> ();
        trackList.put("inN","this is nice");
        trackList.put("aadi","aadi el kol aadi el nas aadi hadaka aali jawak..");
        trackList.put("koholoatmeh","fish eshi be el denya kolshe aswad kohol o atmeh");
        trackList.put("kteerktar","kteer ktaar el nas bt7ki kteer o ana mashi");

        System.out.println(trackList.get("kteerktar"));
        for (String song : trackList.keySet()){
            System.out.println("song name:" +song+"and the lyrics is:"+trackList.get(song));
    }
}
}