package com.ruse.util;

import com.ruse.world.content.LotteryData;

import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.PriorityQueue;

public class ServerData {

    private LotteryData topLottery;
    public LotteryData getTopLottery() {
        return topLottery;
    }

    public void setTopLottery(LotteryData toplottery) {
        this.topLottery = toplottery;
        requestUpdate("topLottery");
    }



    /**
     * Collection of all variables which need to be saved.
     */
    private PriorityQueue<Field> updateQueue = new PriorityQueue<Field>(5, Collections.reverseOrder());
    /**
     * Create an instance of ServerData with all variables deserialized from .var files.
     */
    public ServerData() {
        loadServerData();
    }

    /**
     * Reads all .var files and deserializes them if possible.
     */
    private void loadServerData() {
        initializeVariables();

        File[] fileList = new File("data/server/").listFiles();

        for(File file : fileList) {
            //System.out.println("File name: "+file.getName());
           // System.out.println("File path: "+file.getAbsolutePath());

            System.out.println(" ");
        }
        for (File varFile : fileList) {
            if (varFile.getName().endsWith(".var")) {
                try {
                    setVariable(varFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Deserialize the specified file and attempt to set the class level variable with the file name to it.
     *
     * @param varFile The serialized variable file
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("unchecked")
    private <T> void setVariable(File varFile) throws ClassNotFoundException, IOException, IllegalArgumentException, IllegalAccessException {
        try {
            String varName = FilenameUtils.removeExtension(varFile.getName());
            Field field = ServerData.class.getDeclaredField(varName);
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(varFile));
            T variable = (T) in.readObject();

            field.set(this, variable);
            in.close();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return;
        }
    }

    /**
     * Create an instance of all variables to avoid Null Pointer Exceptions when trying to access variables which aren't loaded from a file.
     */
    private void initializeVariables() {
        Field[] fields = ServerData.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                if (field.get(this) == null) {
                    field.set(this, field.getType().newInstance());
                }
            } catch (IllegalArgumentException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Calls the save method for all class level variables.
     */
    public synchronized void saveServerData() {
        Field[] fields = ServerData.class.getDeclaredFields();
        for (Field field : fields) {
            saveField(field);
        }
    }

    /**
     * Serialize and save a variable.
     *
     * @param field The variable as a field.
     */
    public synchronized void saveField(Field field) {
        if (field.getName().equals("updateQueue")) {
            return;
        }
        File tempFile = new File("data/server/" + field.getName() + ".tmp");
        tempFile.delete();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tempFile));
            out.writeObject(field.get(this));
            out.close();
            new File("data/server/" + field.getName() + ".var").delete();
            tempFile.renameTo(new File("data/server/" + field.getName() + ".var"));
        } catch (NotSerializableException e) {
            e.printStackTrace();
            return;
        } catch (IOException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        tempFile.delete();
    }

    /**
     * Issue a request to save the class level variable. The variable will be updated once {@link ServerData#saveQueue} is called.
     *
     * @param varName The name of the variable.
     */
    private void requestUpdate(String varName) {
        try {
            Field field = ServerData.class.getDeclaredField(varName);
            updateQueue.add(field);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves all variables which are stored in the {@link #updateQueue} and empties the queue.
     */
    public void processQueue() {
        Field field;
        while ((field = updateQueue.poll()) != null) {
            saveField(field);
        }
    }

}
