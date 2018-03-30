package sam.scoutdatacompression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sam on 3/28/18.
 */
public class Constant {

    public static final ArrayList<String> nestedKeys = new ArrayList<>(Arrays.asList(
            "allianceSwitchAttemptTele",
            "allianceSwitchAttemptAuto",
            "climb",
            "opponentSwitchAttemptTele",
            "scaleAttemptTele",
            "scaleAttemptAuto"
    ));
    public static final ArrayList<String> unnestedKeyWithArrayValue = new ArrayList<>(Arrays.asList(
            "alliancePlatformIntakeAuto",
            "alliancePlatformIntakeTele",
            "opponentPlatformIntakeTele"

    ));

    public static final String scoutdata = "{\n" +
            "\t\"1678Q15-12\": {\n" +
            "\t\t\"numCubesFumbledAuto\": 0,\n" +
            "\t\t\"didMakeAutoRun\": true,\n" +
            "\t\t\"scoutName\": \"Erik\",\n" +
            "\t\t\"numGroundIntakeTele\": 6,\n" +
            "\t\t\"matchNumber\": 15,\n" +
            "\t\t\"allianceSwitchAttemptTele\": [{\n" +
            "\t\t\t\"status\": \"opponentOwned\",\n" +
            "\t\t\t\"layer\": 2,\n" +
            "\t\t\t\"endTime\": 100.4,\n" +
            "\t\t\t\"startTime\": 96.37,\n" +
            "\t\t\t\"didSucceed\": true\n" +
            "\t\t}],\n" +
            "\t\t\"climb\": [{\n" +
            "\t\t\t\"activeLift\": {\n" +
            "\t\t\t\t\"numRobotsLifted\": 1,\n" +
            "\t\t\t\t\"partnerLiftType\": \"passive\",\n" +
            "\t\t\t\t\"didFailToLift\": false,\n" +
            "\t\t\t\t\"didClimb\": true,\n" +
            "\t\t\t\t\"startTime\": 114.64,\n" +
            "\t\t\t\t\"didSucceed\": true,\n" +
            "\t\t\t\t\"endTime\": 123.46\n" +
            "\t\t\t}\n" +
            "\t\t}],\n" +
            "\t\t\"numCubesFumbledTele\": 1,\n" +
            "\t\t\"numGroundPyramidIntakeTele\": 0,\n" +
            "\t\t\"numReturnIntake\": 0,\n" +
            "\t\t\"alliancePlatformIntakeAuto\": [false, false, false, false, false, false],\n" +
            "\t\t\"startingPosition\": \"center\",\n" +
            "\t\t\"didPark\": false,\n" +
            "\t\t\"numSpilledCubesAuto\": 0,\n" +
            "\t\t\"opponentSwitchAttemptTele\": [{\n" +
            "\t\t\t\"endTime\": 42.88,\n" +
            "\t\t\t\"startTime\": 40.37,\n" +
            "\t\t\t\"didSucceed\": false\n" +
            "\t\t}, {\n" +
            "\t\t\t\"status\": \"opponentOwned\",\n" +
            "\t\t\t\"layer\": 1,\n" +
            "\t\t\t\"endTime\": 62.1,\n" +
            "\t\t\t\"startTime\": 57.87,\n" +
            "\t\t\t\"didSucceed\": true\n" +
            "\t\t}, {\n" +
            "\t\t\t\"status\": \"opponentOwned\",\n" +
            "\t\t\t\"layer\": 1,\n" +
            "\t\t\t\"endTime\": 76.32,\n" +
            "\t\t\t\"startTime\": 71.32,\n" +
            "\t\t\t\"didSucceed\": true\n" +
            "\t\t}, {\n" +
            "\t\t\t\"status\": \"opponentOwned\",\n" +
            "\t\t\t\"layer\": 1,\n" +
            "\t\t\t\"endTime\": 84.18,\n" +
            "\t\t\t\"startTime\": 80.56,\n" +
            "\t\t\t\"didSucceed\": true\n" +
            "\t\t}],\n" +
            "\t\t\"numGroundPyramidIntakeAuto\": 1,\n" +
            "\t\t\"numExchangeInput\": 0,\n" +
            "\t\t\"totalNumScaleFoul\": 0,\n" +
            "\t\t\"numSpilledCubesTele\": 0,\n" +
            "\t\t\"didGetDisabled\": false,\n" +
            "\t\t\"alliancePlatformIntakeTele\": [true, true, true, false, false, false],\n" +
            "\t\t\"numHumanPortalIntakeTele\": 0,\n" +
            "\t\t\"didGetIncapacitated\": false,\n" +
            "\t\t\"scaleAttemptTele\": [{\n" +
            "\t\t\t\"status\": \"balanced\",\n" +
            "\t\t\t\"layer\": 1,\n" +
            "\t\t\t\"endTime\": 12.5,\n" +
            "\t\t\t\"startTime\": 10.78,\n" +
            "\t\t\t\"didSucceed\": true\n" +
            "\t\t}, {\n" +
            "\t\t\t\"status\": \"balanced\",\n" +
            "\t\t\t\"layer\": 1,\n" +
            "\t\t\t\"endTime\": 20.74,\n" +
            "\t\t\t\"startTime\": 18.39,\n" +
            "\t\t\t\"didSucceed\": true\n" +
            "\t\t}, {\n" +
            "\t\t\t\"status\": \"owned\",\n" +
            "\t\t\t\"layer\": 1,\n" +
            "\t\t\t\"endTime\": 28.45,\n" +
            "\t\t\t\"startTime\": 26.82,\n" +
            "\t\t\t\"didSucceed\": true\n" +
            "\t\t}],\n" +
            "\t\t\"opponentPlatformIntakeTele\": [false, false, false, false, false, false],\n" +
            "\t\t\"numGroundPortalIntakeTele\": 0,\n" +
            "\t\t\"allianceSwitchAttemptAuto\": [{\n" +
            "\t\t\t\"status\": \"balanced\",\n" +
            "\t\t\t\"layer\": 1,\n" +
            "\t\t\t\"endTime\": 6.98,\n" +
            "\t\t\t\"startTime\": 2.86,\n" +
            "\t\t\t\"didSucceed\": true\n" +
            "\t\t}, {\n" +
            "\t\t\t\"status\": \"owned\",\n" +
            "\t\t\t\"layer\": 1,\n" +
            "\t\t\t\"endTime\": 14.08,\n" +
            "\t\t\t\"startTime\": 11.09,\n" +
            "\t\t\t\"didSucceed\": true\n" +
            "\t\t}],\n" +
            "\t\t\"teamNumber\": 1678,\n" +
            "\t\t\"numElevatedPyramidIntakeTele\": 0,\n" +
            "\t\t\"numElevatedPyramidIntakeAuto\": 0\n" +
            "\t}\n" +
            "}";



        //replace with new datapoints
       public static Map<String, String> compressKeys = new HashMap<String, String>() {{
            //New constants
            put("layer", "J");
            put("numCubesFumbledAuto", "F");
            put("didMakeAutoRun", "V");
            put("scoutName", "e");
            put("activeLift", "Q");
            put("numGroundIntakeTele", "g");
            put("matchNumber", "E");
            put("soloClimb", "P");
            put("allianceSwitchAttemptTele", "h");
            put("climb", "G");
            put("numCubesFumbledTele", "q");
            put("numGroundPyramidIntakeTele", "n");
            put("numReturnIntake", "c");
            put("numRobotsLifted", "w");
            put("partnerLiftType", "C");
            put("didFailToLift", "j");
            put("alliancePlatformIntakeAuto", "o");
            put("startingPosition", "m");
            put("didSucceed", "K");
            put("status", "r");
            put("didPark", "B");
            put("numSpilledCubesAuto", "Y");
            put("assistedClimb", "k");
            put("opponentSwitchAttemptTele", "l");
            put("numGroundPyramidIntakeAuto", "i");
            put("numExchangeInput", "L");
            put("didClimb", "v");
            put("totalNumScaleFoul", "z");
            put("startTime", "f");
            put("numSpilledCubesTele", "Z");
            put("didGetDisabled", "T");
            put("alliancePlatformIntakeTele", "I");
            put("numHumanPortalIntakeTele", "p");
            put("didGetIncapacitated", "y");
            put("endTime", "a");
            put("scaleAttemptTele", "S");
            put("opponentPlatformIntakeTele", "t");
            put("numGroundPortalIntakeTele", "M");
            put("allianceSwitchAttemptAuto", "W");
            put("passiveClimb", "D");
            put("teamNumber", "b");
            put("numElevatedPyramidIntakeTele", "R");
            put("numElevatedPyramidIntakeAuto", "H");
        }};


        //replace with new datapoints
    public static Map<String, String> compressValues = new HashMap<String, String>() {{
            //New constants
            put("both", "X");
            put("right", "O");
            put("center", "d");
            put("opponentOwned", "U");
            put("owned", "u");
            put("passive", "x");
            put("active", "s");
            put("balanced", "A");
            put("left", "N");
            put("true", "1");
            put("false", "0");
        }};

}
