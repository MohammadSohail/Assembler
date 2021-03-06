import java.io.*;
import java.util.*;
public class Assembler {
    static Map<String, String> registers = new HashMap<>();
    static Map<String, String> operation = new HashMap<>();
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(new FileInputStream("input.txt"));
        PrintWriter pw = new PrintWriter(new FileOutputStream("output.txt"));

        buildOperationMap();
        buildRegisterMap();

        try {

            StringTokenizer st;
            while (in.hasNextLine()) {
                String inputLine = in.nextLine();
                st = new StringTokenizer(inputLine, ", ");
                String op = st.nextToken();
                String result = "", rd, rs, rt, immediate, target;

                switch (op) {
                    case "ADD":
                        rd = st.nextToken();
                        rs = st.nextToken();
                        rt = st.nextToken();
                        result = operation.get(op) + registers.get(rd) + registers.get(rs) + registers.get(rt);
                        break;

                    case "SUB":
                        rd = st.nextToken();
                        rs = st.nextToken();
                        rt = st.nextToken();
                        result = operation.get(op) + registers.get(rd) + registers.get(rs) + registers.get(rt);
                        break;

                    case "AND":
                        rd = st.nextToken();
                        rs = st.nextToken();
                        rt = st.nextToken();
                        result = operation.get(op) + registers.get(rd) + registers.get(rs) + registers.get(rt);
                        break;

                    case "OR":
                        rd = st.nextToken();
                        rs = st.nextToken();
                        rt = st.nextToken();
                        result = operation.get(op) + registers.get(rd) + registers.get(rs) + registers.get(rt);
                        break;

                    case "SLT":
                        rd = st.nextToken();
                        rs = st.nextToken();
                        rt = st.nextToken();
                        result = operation.get(op) + registers.get(rd) + registers.get(rs) + registers.get(rt);
                        break;

                    case "SLR":
                        rd = st.nextToken();
                        rs = st.nextToken();
                        rt = st.nextToken();
                        result = operation.get(op) + registers.get(rd) + registers.get(rs) + registers.get(rt);
                        break;

                    case "SLL":
                        rd = st.nextToken();
                        immediate = st.nextToken();
                        result = operation.get(op) + registers.get(rd) + immediate;
                        break;

                    case "ADDi":
                        rt = st.nextToken();
                        rs = st.nextToken();
                        immediate = st.nextToken();
                        result = operation.get(op) + registers.get(rt) + registers.get(rs) + immediate;
                        break;

                    case "ANDi":
                        rt = st.nextToken();
                        rs = st.nextToken();
                        immediate = st.nextToken();
                        result = operation.get(op) + registers.get(rt) + registers.get(rs) + immediate;
                        break;

                    case "ORi":
                        rt = st.nextToken();
                        rs = st.nextToken();
                        immediate = st.nextToken();
                        result = operation.get(op) + registers.get(rt) + registers.get(rs) + immediate;
                        break;

                    case "SLLi":
                        rt = st.nextToken();
                        rs = st.nextToken();
                        immediate = st.nextToken();
                        result = operation.get(op) + registers.get(rt) + registers.get(rs) + immediate;
                        break;

                    case "LW":
                        rt = st.nextToken();
                        rs = st.nextToken();
                        immediate = st.nextToken();
                        result = operation.get(op) + registers.get(rt) + registers.get(rs) + immediate;
                        break;

                    case "SW":
                        rt = st.nextToken();
                        rs = st.nextToken();
                        immediate = st.nextToken();
                        result = operation.get(op) + registers.get(rt) + registers.get(rs) + immediate;
                        break;

                    case "BEQ":
                        rt = st.nextToken();
                        rs = st.nextToken();
                        target = st.nextToken();
                        result = operation.get(op) + registers.get(rt) + registers.get(rs) + target;
                        break;

                    case "BNE":
                        rt = st.nextToken();
                        rs = st.nextToken();
                        target = st.nextToken();
                        result = operation.get(op) + registers.get(rt) + registers.get(rs) + target;
                        break;

                    case "JUMP":
                        target = st.nextToken();
                        result = operation.get(op) + target;
                        break;
                }

                if(st.hasMoreElements()){
                    System.out.println("Invalid Input");
                    continue;
                }

                String binaryString = result;
                String hexString = Long.toHexString(Long.parseLong(result, 2));
                hexString = String.format("%4s", hexString).replace(' ', '0');
                
                pw.println(binaryString);
                //pw.println(hexString);

            }
        }
        catch (Exception e){
            System.out.println("Invalid input");
        }

        pw.close();
        in.close();
    }

    static void buildOperationMap(){
        operation.put("ADD", "0000");
        operation.put("SUB", "0001");
        operation.put("AND", "0010");
        operation.put("OR", "0011");
        operation.put("SLT", "0100");
        operation.put("SLR", "0101");
        operation.put("SLL", "0110");
        operation.put("ADDi", "0111");
        operation.put("ANDi", "1000");
        operation.put("ORi", "1001");
        operation.put("SLLi", "1010");
        operation.put("LW", "1011");
        operation.put("SW", "1100");
        operation.put("BEQ", "1101");
        operation.put("BNE", "1110");
        operation.put("JUMP", "111111111111");
    }

    static void buildRegisterMap(){
        registers.put("$zero", "0000");
        registers.put("$t0", "0001");
        registers.put("$t1", "0010");
        registers.put("$t2", "0011");
        registers.put("$t3", "0100");
        registers.put("$t4", "0101");
        registers.put("$t5", "0110");
        registers.put("$t6", "0111");
        registers.put("$s0", "1000");
        registers.put("$s1", "1001");
        registers.put("$s2", "1010");
        registers.put("$s3", "1011");
        registers.put("$s4", "1100");
        registers.put("$s5", "1101");
        registers.put("$s6", "1110");
        registers.put("$s7", "1111");
    }
}
