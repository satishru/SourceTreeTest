package com.example.mvptask.utils;

import com.example.mvptask.TaskApplication;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public final class CommonUtils {
    /**
     *
     * @param value
     * @return formatted decimal format with grouping
     */
    public static String formatDecimal(Double value) {
        DecimalFormat df = new DecimalFormat("#,###.00");
        BigDecimal example = new BigDecimal(String.valueOf(value));
        return df.format(example);
    }

    /**
     *
     * @return String Json Data
     * Load String (data.json) file from assets folder
     */
    public static String loadJSONFromAsset(String file_name) {
        String json = null;
        try {
            InputStream is = TaskApplication.getGlobalContext().getAssets().open(file_name);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
