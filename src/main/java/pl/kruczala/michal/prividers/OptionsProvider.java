package pl.kruczala.michal.prividers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OptionsProvider {


    public char readChar() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return (char) bufferedReader.read();
    }

    public String readString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader.readLine();
    }

    public int readInt() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return Integer.parseInt(bufferedReader.readLine());
    }
}