package space.generics.superburger.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import space.generics.superburger.environment.Utils;
import space.generics.superburger.exception.exceptions.EmptyFileException;
import space.generics.superburger.exception.exceptions.UnreachableLocalStorageException;
import space.generics.superburger.service.FileService;

@Service
public class LocalFileServiceImpl implements FileService {
    
    private static final char[] SYMBOLS = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y', 'z', '$', '?', '(', ')'
    };
    
    private static final File DIRECTORY;
    
    static {
        DIRECTORY = new File("files");
        if (!DIRECTORY.exists()) {
            DIRECTORY.mkdir();
        }
    }
    
    private static String generateName() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int index = Utils.randomInt(0, SYMBOLS.length);
            stringBuilder.append(SYMBOLS[index]);
        }
        String result = stringBuilder.toString();
        File file = new File(DIRECTORY, result);
        return file.exists() ? generateName() : result;
    }
    
    private static String getFileExtention(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        return fileName.substring(fileName.lastIndexOf('.'));
    }
    
    @Override
    public String upload(MultipartFile file) {
        if (file.isEmpty()) {
            throw new EmptyFileException(file.getName());
        }
        String name = LocalFileServiceImpl.DIRECTORY.getPath()
                .concat("/")
                .concat(LocalFileServiceImpl.generateName())
                .concat(LocalFileServiceImpl.getFileExtention(file));
        try (FileOutputStream stream = new FileOutputStream(name)) {
            byte[] bytes = file.getBytes();
            stream.write(bytes);
            return name;
        } catch (IOException ioe) {
            throw new UnreachableLocalStorageException();
        }
    }

}
