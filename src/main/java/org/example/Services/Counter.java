package org.example.Services;

import java.io.IOException;

public class Counter implements AutoCloseable {
    private static Integer globalCount;

    public Counter(Integer globalCount) {
        this.globalCount = globalCount;
    }

    public Integer getGlobalCount() throws IOException {
        isClose();
        return globalCount;
    }

    public void setGlobalCount(Integer globalCount) throws IOException {
        isClose();
        this.globalCount = globalCount;
    }

    public void add() throws IOException {
        isClose();
        globalCount++;
    }

    @Override
    public void close() throws IOException {
        isClose();
        this.globalCount = null;
    }

    public void isClose() throws IOException {
        if(globalCount == null) {
            throw new IOException("Экземпляр закрыт");
        }
    }
}
