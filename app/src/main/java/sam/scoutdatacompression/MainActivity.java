package sam.scoutdatacompression;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //todo use this method to pass the stringed scout data json.

    public String finalCompressedScoutData(String scoutJSON) {
        String compressedData = "";
        try {
            //FIRST, COMPRESS THE DATAPOINTS THAT HAVE NO NESTED KEYS
            JSONObject uncompressed = new JSONObject(Constant.scoutdata); // <--- TODO replace 'Constant.scoutdata' with scoutJSON. The former is just for testing purposes.
            String headerKey = getHeaderKey(uncompressed.keys());
            JSONObject uncompressedUnderHeaderKey = new JSONObject(uncompressed.getString(headerKey));
            JSONObject compressed = new JSONObject();
            Iterator<?> uncompressedKeys = uncompressedUnderHeaderKey.keys();
            while (uncompressedKeys.hasNext()) {
                String key = (String) uncompressedKeys.next();
                if(!Constant.nestedKeys.contains(key)){
                    if(!Constant.unnestedKeyWithArrayValue.contains(key)){
                        if (Constant.compressValues.containsKey(uncompressedUnderHeaderKey.get(key).toString())){
                            if(uncompressedUnderHeaderKey.get(key).toString().equals("true") || uncompressedUnderHeaderKey.get(key).toString().equals("false")){
                                compressed.put(Constant.compressKeys.get(key), Double.parseDouble(Constant.compressValues.get(uncompressedUnderHeaderKey.get(key).toString())));
                            }else{
                                compressed.put(Constant.compressKeys.get(key), Constant.compressValues.get(uncompressedUnderHeaderKey.get(key).toString()));
                            }
                        } else {
                            if(key.equals("scoutName")){
                                compressed.put(Constant.compressKeys.get(key), uncompressedUnderHeaderKey.get(key).toString());
                            }else{
                                compressed.put(Constant.compressKeys.get(key), Double.parseDouble(uncompressedUnderHeaderKey.get(key).toString()));
                            }
                        }
                    }else{
                        JSONArray list = uncompressedUnderHeaderKey.getJSONArray(key);
                        JSONArray compressedList = new JSONArray();
                        for(int i = 0; i < list.length(); ++i){
                            compressedList.put(Integer.parseInt(Constant.compressValues.get(list.get(i).toString())));
                        }
                        compressed.put(Constant.compressKeys.get(key),compressedList);
                    }
                }
            }
            //THEN, COMPRESS DATAPOINTS WITH NESTED KEYS
            for(int i = 0; i < Constant.nestedKeys.size(); i++){
                JSONArray listOfDicts = new JSONArray();
                String nestedKey = Constant.nestedKeys.get(i);
                if(!nestedKey.equals("climb")) {
                    if (uncompressedUnderHeaderKey.has(nestedKey)) {
                        JSONArray keyWithNestedKeys = uncompressedUnderHeaderKey.getJSONArray(nestedKey);
                        for (int j = 0; j < keyWithNestedKeys.length(); ++j){
                            JSONObject compressedJ1 = new JSONObject();
                            JSONObject j1 = keyWithNestedKeys.getJSONObject(j);
                            Iterator<?> j1Keys = j1.keys();
                            while (j1Keys.hasNext()) {
                                String key = (String) j1Keys.next();
                                if (Constant.compressValues.containsKey(j1.get(key).toString())) {
                                    if (j1.get(key).toString().equals("true") || j1.get(key).toString().equals("false")) {
                                        compressedJ1.put(Constant.compressKeys.get(key), Double.parseDouble(Constant.compressValues.get(j1.get(key).toString())));
                                    } else {
                                        compressedJ1.put(Constant.compressKeys.get(key), Constant.compressValues.get(j1.get(key).toString()));
                                    }
                                } else {
                                    compressedJ1.put(Constant.compressKeys.get(key), Double.parseDouble(j1.get(key).toString()));
                                }
                            }
                            listOfDicts.put(compressedJ1);
                            compressed.put(Constant.compressKeys.get(nestedKey), listOfDicts);
                        }
                    }
                }else{
                    //CLIMB DATA HAS DOUBLE NESTED KEYS
                    for (int k = 0; k < uncompressedUnderHeaderKey.getJSONArray(nestedKey).length(); ++k){
                        JSONObject compressedJ2 = new JSONObject();
                        JSONObject climbData = uncompressedUnderHeaderKey.getJSONArray(nestedKey).getJSONObject(k);
                        JSONObject tempCompressed = new JSONObject();
                        String climbTitle = getHeaderKey(climbData.keys());
                        JSONObject climbDetails = new JSONObject(climbData.get(climbTitle).toString());
                        Iterator<?> j1Keys = climbDetails.keys();
                        while (j1Keys.hasNext()) {
                            String key = (String) j1Keys.next();
                            if (Constant.compressValues.containsKey(climbDetails.get(key).toString())) {
                                if(climbDetails.get(key).toString().equals("true") || climbDetails.get(key).toString().equals("false")){
                                    compressedJ2.put(Constant.compressKeys.get(key), Double.parseDouble(Constant.compressValues.get(climbDetails.get(key).toString())));
                                }else{
                                    compressedJ2.put(Constant.compressKeys.get(key), Constant.compressValues.get(climbDetails.get(key).toString()));
                                }
                            } else {
                                compressedJ2.put(Constant.compressKeys.get(key), Double.parseDouble(climbDetails.get(key).toString()));
                            }
                        }
                        tempCompressed.put(Constant.compressKeys.get(climbTitle), compressedJ2);
                        listOfDicts.put(tempCompressed);
                        compressed.put(Constant.compressKeys.get(nestedKey), listOfDicts);
                    }

                }
            }
            compressedData = headerKey + "|" + compressed.toString().substring(1, compressed.toString().length()-1).replace("\"", "").replace(" ", "");
            Log.e("FINAL", compressedData.toString());
        } catch (JSONException JE) {
            Log.e("CHECKPOINT", "SOMETHING WENT WRONG");
        }
        return compressedData;
    }

    public String getHeaderKey(Iterator<?> keys) {
        String key = "";
        while (keys.hasNext()) {
            key = (String) keys.next();
        }
        return key;
    }

}
