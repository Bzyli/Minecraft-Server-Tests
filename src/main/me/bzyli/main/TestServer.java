package main.me.bzyli.main;

import java.net.*;
import java.io.*;

public class TestServer  extends  Thread{


    String thing = "{\n" +
            "    \"version\": {\n" +
            "        \"name\": \"1.16.4\",\n" +
            "        \"protocol\": 754\n" +
            "    },\n" +
            "    \"players\": {\n" +
            "        \"max\": 100,\n" +
            "        \"online\": 5,\n" +
            "        \"sample\": [\n" +
            "            {\n" +
            "                \"name\": \"thinkofdeath\",\n" +
            "                \"id\": \"4566e69f-c907-48ee-8d71-d7ba5aa00d20\"\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"description\": {\n" +
            "        \"text\": \"Hello world\"\n" +
            "    },\n" +
            "    \"favicon\": \"data:image/png;base64,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\"\n" +
            "}";
    final static int port = 25565;
    private Socket socket;

    public static void main(String[] args) {
        try {
            ServerSocket socketServeur = new ServerSocket(port);
            System.out.println("Lancement du serveur");
            while (true) {
                Socket socketClient = socketServeur.accept();
                TestServer t = new TestServer(socketClient);
                t.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TestServer(Socket sockete) {
        this.socket = sockete;
    }

    public void run() {
        traitements();
    }

    public void traitements() {
        try {
            String message = "";

            System.out.println("Connexion avec le client : " + socket.getInetAddress());

            InputStream in = socket.getInputStream();
            int length = readVarInt(in);
            System.out.println("Length" + length);
            int id = readVarInt(in);
            System.out.println("ID" + id);
            OutputStream outstream = socket.getOutputStream();
            DataOutputStream out = new DataOutputStream(outstream);


            switch(id) {
                case 0:
                    System.out.println("Handshake packet");
                    int protocolVersion = readVarInt(in);
                    System.out.println("Protocol version: " + protocolVersion);
                    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                    DataOutputStream packet = new DataOutputStream(byteStream);
                    writeVarInt(0, packet); // Write packet ID for Response
                    writeString(thing, packet);

                    writeVarInt(byteStream.size(), out); // Write length
                    byteStream.writeTo(out); // Write data

                    break;
                default:
                    System.out.println("Unknown packet ID " + id);
            }




            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int readVarInt(InputStream in) throws IOException {
        int numRead = 0;
        int result = 0;
        byte read;
        do {
            read = (byte) in.read();
            int value = (read & 0b01111111);
            result |= (value << (7 * numRead));

            numRead++;
            if (numRead > 5) {
                throw new RuntimeException("VarInt is too big");
            }
        } while ((read & 0b10000000) != 0);

        return result;
    }

    public static void writeVarInt(int value, DataOutputStream out) throws IOException {
        do {
            byte temp = (byte)(value & 0b01111111);
            // Note: >>> means that the sign bit is shifted with the rest of the number rather than being left alone
            value >>>= 7;
            if (value != 0) {
                temp |= 0b10000000;
            }
            out.writeByte(temp);
        } while (value != 0);
    }

    public static void writeString(String string, DataOutputStream out) throws IOException {
        byte[] bytes = string.getBytes("utf-8");

        writeVarInt(bytes.length, out); // Write string length
        out.write(bytes);
    }

    public static void writeVarLong(int value, DataOutputStream out) throws IOException {
        do {
            byte temp = (byte)(value & 0b01111111);
            // Note: >>> means that the sign bit is shifted with the rest of the number rather than being left alone
            value >>>= 7;
            if (value != 0) {
                temp |= 0b10000000;
            }
            out.writeByte(temp);
        } while (value != 0);
    }

}
