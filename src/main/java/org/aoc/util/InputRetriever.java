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

        request.addHeader("cookie", "_ga=GA1.2.1501474227.1699435046; session=53616c7465645f5fb571084e10b6e70c2c5db9dfd532e578dd8d9c7eba5a8166114ed57a0503723d6d2063b19ac19d7b258cbc327ee2ead887e64d2ed163fabb; _gid=GA1.2.1954672237.1701673595; _gat=1");

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
