package com.saidozcan.kiraz;

import java.util.HashMap;
import java.util.List;
import java.util.*;
import com.google.gson.*;

/**
 * Created by mozcan on 21/05/2017.
 */
public class JSONEncoder {

    public JSONEncoder() {

    }

    public String encodeJsonFromList(List<HashMap<String, String>> list) {
        return new Gson().toJson(list);
    }
}
