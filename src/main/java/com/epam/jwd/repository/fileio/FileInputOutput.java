package com.epam.jwd.repository.fileio;

import com.epam.jwd.repository.exception.RepositoryException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileInputOutput {

    private static final Logger logger = LogManager.getLogger(FileInputOutput.class);

    private static final String STRING_FILE_NOT_FOUND_EXCEPTION = "FileNotFoundException happened";
    private static final String STRING_IO_EXCEPTION = "IOException happened";
    private static final String STRING_CLASS_NOT_FOUND_EXCEPTION = "ClassNotFoundException happened";

    public static <T> void read(String path, List<T> destination){
        try(FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object object = ois.readObject();
            if (object instanceof List){
                destination.addAll((List<T>) object);
            }
        } catch (FileNotFoundException e) {
            logger.error(STRING_FILE_NOT_FOUND_EXCEPTION, e);
            throw new RepositoryException(STRING_FILE_NOT_FOUND_EXCEPTION);
        } catch (IOException e) {
            logger.error(STRING_IO_EXCEPTION, e);
            throw new RepositoryException(STRING_IO_EXCEPTION);
        } catch (ClassNotFoundException e) {
            logger.error(STRING_CLASS_NOT_FOUND_EXCEPTION, e);
            throw new RepositoryException(STRING_CLASS_NOT_FOUND_EXCEPTION);
        }
    }

    public static <T> void save(String path, List<T> source){
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(source);
        } catch (FileNotFoundException e) {
            logger.error(STRING_FILE_NOT_FOUND_EXCEPTION, e);
            throw new RepositoryException(STRING_FILE_NOT_FOUND_EXCEPTION);
        } catch (IOException e) {
            logger.error(STRING_IO_EXCEPTION, e);
            throw new RepositoryException(STRING_IO_EXCEPTION);
        }
    }
}
