package basicjava.bitmanipulation;

//import io.netty.buffer.ByteBuf;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.BitSet;

/**
 * Created by mahesh.govind on 3/6/16.
 */
public class Shift {

    public static int getBitsAsInteger(byte value, int offset, int size) {
        return (value >>> offset) & ((1 << size) - 1);
    }


    public static boolean isBitSet(byte value, int offset) {
        return ((value >>> offset) & 1) != 0;
    }

    public static byte setBitsAsInteger(byte value, int offset, int size, int target) {
        int shiftedTarget = (target & ((1 << size) - 1)) << offset;
        int mask = ~(((1 << size) - 1) << offset);
        return (byte) (value & mask | shiftedTarget);
    }


    public static byte setBit(byte value, int offset, boolean target) {
        if (target) {
            return (byte) (value | (1 << offset));
        } else {
            return (byte) (value & ~(1 << offset));
        }
    }
    public static int mask(int start,int end){
        int allOnes = 0b11111111111111111111111111111111;
        int left =  allOnes << (32 - start );
        int right =  ((1 <<  (32 - end)) - 1);
        int mask = left |right;
        return mask;
    }

    public static int setIntegerAsBits( int value , int index, int size,int target){
        int setter = value << (32 - (size + index )) ;
        int mask = mask(index,index+size);
        int newTarget = ( target & mask) | setter;
        return  newTarget;
    }

    //index is from left .
    public static int getBitsAsInteger(int input ,int index , int size){
        int mask = mask(index,index+size);
        // index 0, size 32
        //index  32 size 0
        int massageInput = ~mask & input;
        int tmp = massageInput>>>(32-(index+size));
        return tmp;
    }

    int getByteAInteger( byte input ){
        int tmp = 0;

        tmp |=input;
        return tmp;

    }
    public static void print(int input,String message){
        System.out.println(message + " int "+input);
        System.out.println(message +"  "+Integer.toBinaryString(input));


    }

    /*0                   1                   2                   3
        0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
       +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
       |CAPWAP Preamble|  HLEN   |   RID   | WBID    |T|F|L|W|M|K|Flags|
       +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
       |          Fragment ID          |     Frag Offset         |Rsvd |
       +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
       |                 (optional) Radio MAC Address                  |
       +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
       |            (optional) Wireless Specific Information           |
       +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
       |                        Payload ....                           |
       +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
       */

    /*
    // An 8-bit 'byte' value:
    byte aByte = (byte)0b 0 0 1 0 0 0 0 1;

    // A 16-bit 'short' value:
    short aShort = (short)0b1010000101000101;

    // Some 32-bit 'int' values:
    int anInt1 = 0b10100001010001011010000101000101;
     */

    public static void  main( String [] args) throws SocketException {

        ClientSocket sock = new ClientSocket(5246);
/*        ByteBuffer buf = ByteBuffer.allocate(20).order(ByteOrder.BIG_ENDIAN);


        //buf.putInt(0b0000 0000 10000 00101 00001 010000 000);
        buf.putInt(0b00000000100000010100001010000000);
        buf.putInt(0b00000000000000000000000000000000);
        buf.putInt(0b00000000000000000000000000000000);
        buf.putInt(0b00000000000000000000000000000000);*/

       // sock.sendMessage2(buf.array());

        //ByteBuffer recvBuff = ByteBuffer.allocate(20).order(ByteOrder.BIG_ENDIAN);
        //recvBuff.put(buf);

        byte b = (byte) 0b11111111;


        int _32bit_signed  = 0b10000000000000000000000000000001;
        //int _32bit_no_signed  = 0b10000000000000000000000000000001;
        int _32bit_signed2  = 0b10000000000000000000000000000000;
        /*System.out.printf("31 >>shifted value           %d\n" , _32bit_signed>>1);
        System.out.printf("31  >>> shifted value        %d\n" , _32bit_signed>>>1);
        System.out.printf(" shiftedunsigned 31 <<value  %d\n" , _32bit_no_signed<<31);
        System.out.printf(" NOt shifted signed          %d\n" , _32bit_signed2);
        System.out.printf("The byte %s",b);
        */
        int x = 100;
        System.out.println("original 32bitsigned"+ Integer.toBinaryString(_32bit_signed));
        //System.out.println(Integer.toBinaryString(_32bit_no_signed));
       // System.out.println("original 32bitsigned2"+ Integer.toBinaryString(_32bit_signed2));
        System.out.println("original 32bitsigned in int "+ _32bit_signed);
        //System.out.println(_32bit_no_signed);
       // System.out.println("original 32bitsigned2 in int "+_32bit_signed2);
        int right1shiftedvalue1wrong = _32bit_signed>>1;
        int right1shiftedvalue1right = _32bit_signed>>>1;
        int left31shiftedvalurright = _32bit_signed<<31;
        System.out.println("right1shiftedvalue1wrong 32bitsigned "+ Integer.toBinaryString(right1shiftedvalue1wrong));
        System.out.println("right1shiftedvalue1right 32bitsigned "+ Integer.toBinaryString(right1shiftedvalue1right));
        System.out.println("left31shiftedvalurright 32bitsigned "+ Integer.toBinaryString(left31shiftedvalurright));

        System.out.println("right1shiftedvalue1wrong 32bitsigned int "+right1shiftedvalue1wrong);
        System.out.println("right1shiftedvalue1right 32bitsigned int "+ right1shiftedvalue1right);
        System.out.println("left31shiftedvalurright 32bitsigned int "+ left31shiftedvalurright);

        int setBit5index5size3 = setIntegerAsBits(5,5,7,_32bit_signed);
        print(setBit5index5size3,"setBit5index5size3");
        int getBit5index5size3 = getBitsAsInteger(setBit5index5size3,5,7);
        print(getBit5index5size3,"getBit5index5size3");
        print(mask(4,9),"mask");

    }


}