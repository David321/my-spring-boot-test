package com.davidcorp.myspringboottest.conditionalTest;

public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
