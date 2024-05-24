package midCommands;

import java.util.HashMap;
import java.util.List;


public class MID0242 {
    //
    public String replyMID(String answer) {
        if (answer.equalsIgnoreCase("acknowledge")) {
            return "midCommands.MID0243";
        } else if (answer.equalsIgnoreCase("accept")) {
            return "midCommands.MID0243";
        } else {
            return null;
        }
    }
    //
    // MID 0242 User data
    public String integratorString(String midCommandValue, List<Object> dataFieldValue) {
		//
        String midRevision = "001";
        String midAckFlag = "0";
        String midStationID = "00";
        String midSpindleID = "00";
        String midSpare = "0000";
        //
        StringBuilder midAscii = new StringBuilder();
        StringBuilder tempMidAscii = new StringBuilder();
        // MID
        tempMidAscii.append(midCommandValue);
        // Revision
        tempMidAscii.append(midRevision);
        // No Ack flag
        tempMidAscii.append(midAckFlag);
        // StationID flag
        tempMidAscii.append(midStationID);
        // SpindleID flag
        tempMidAscii.append(midSpindleID);
        // Spare
        tempMidAscii.append(midSpare);
        //
        // Data Field
        if (!dataFieldValue.isEmpty()) {
            for (Object s : dataFieldValue) {
                tempMidAscii.append(s);
            }
        }
        // Length
        int midLength = tempMidAscii.length() + 4;
        // combine string
        midAscii.append(String.format("%04d", midLength)).append(tempMidAscii);
        //
        return (midAscii + "\0");
    }
    //
    public HashMap<String, HashMap<String, Object>> controllerString(String controllerMsg, String midCommand, String midLengthString, String midRevision) {
        //
        HashMap<String, HashMap<String, Object>> midControllerHash = new HashMap<String, HashMap<String, Object>>();
        HashMap<String, Object> controllerHash = new HashMap<String, Object>();
        try {
            //
            controllerHash.put("USER_DATA", controllerMsg.substring(20));
            //
        } catch (StringIndexOutOfBoundsException s) {
            System.out.println("StringIndex Out of Bounds\n" + s.getMessage());
            s.printStackTrace();
            midControllerHash.put(midCommand, controllerHash);
            return midControllerHash;
        }
        //
        midControllerHash.put(midCommand, controllerHash);
        return midControllerHash;
    }
}