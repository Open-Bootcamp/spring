package com.example.springpatterns.patterns.structural.proxy;

public class RealImage implements Image {


    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading image "+ fileName);
    }

    @Override
    public void show() {
        System.out.println("Showing "+ fileName);
    }

}
