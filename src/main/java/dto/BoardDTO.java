package dto;

import interfaces.Path;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;

@Getter
@Setter
@Builder
@ToString

public class BoardDTO implements Serializable, Path {
    private static final long serialVersionUID = 64565461L;
    private String boardTitle;


    public static void main(String[] args) {
        BoardDTO boardDTO = BoardDTO.builder().boardTitle("ser_new").build();
        serializableBoardDTO(boardDTO, "file1.ser");
        System.out.println(deSerializableBoardDTO("file1.ser").toString());
    }

    public static void serializableBoardDTO(BoardDTO boardDTO, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(SERIALIZE_PATH + fileName))) {
            outputStream.writeObject(boardDTO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BoardDTO deSerializableBoardDTO(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(SERIALIZE_PATH + fileName))) {
            return (BoardDTO) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
           return null;
        }
    }


}
