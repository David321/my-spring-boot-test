package com.davidcorp.myspringboottest.conditionalTest;

public class LinuxListService implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}