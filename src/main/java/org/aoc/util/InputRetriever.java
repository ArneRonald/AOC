package org.aoc.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InputRetriever {

    private int year;

    private int day;

    public InputRetriever(int year, int day) {
        this.year = year;
        this.day = day;
    }

    public List<String> getInputAsStringList() {
        String[] inputs = getInputAsStringArray();
        List<String> input = Arrays.asList(inputs);
        return input;
    }

    public String[] getInputAsStringArray() {
        String inputString = FetchInput(this.day);
        String[] inputs = inputString.split("\n");
        return inputs;
    }

    public int[] getInputAsIntegerArray() {
        String inputString = FetchInput(day);
        String[] inputs = inputString.split("\n");
        int[] numbers = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i].equals("")) {
                numbers[i] = 0;
            } else {
                numbers[i] = Integer.parseInt(inputs[i]);
            }
        }
        return numbers;
    }

    public List<Integer> getInputAsIntegerList(){
        int[] input = getInputAsIntegerArray();
        List<Integer> inputs = new LinkedList<>();
        for (int i: input) {
            inputs.add(i);
        }
        return inputs;
    }

    public String FetchInput(int day) {
        String result;
        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpGet request = new HttpGet("https://adventofcode.com/"+ year+"/day/"+ day +"/input");

        request.addHeader("cookie", "_ga=GA1.2.355518904.1669202280; session=53616c7465645f5f518da40fb314078f88b0c5098f306bd4f08d58f80997c29f741d5c0ec4327950938fa7324dc0cadb13d31508a9d6e4c61a77bc4510e792e0; _gid=GA1.2.61648728.1669879033; _gat=1");

        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();

            result = EntityUtils.toString(entity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
