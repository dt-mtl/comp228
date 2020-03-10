public class assign3 {
    /*
                                           // mandatory:
 l.d   f2,4(r1)                            // test program to be
 l.d   f4,8(r3)                            // simulated;
 mul.d f6,f2,f4                            // straight-line code;
 add.d f8,f4,f6                            // no pipelining
 s.d   f6,8(r3)
 s.d   f8,4(r5)

*/
    public static void main(String []args){
        int[] Reg = new int[10];    // register file
        Reg[1] = 100;   // r-register values
        Reg[3] = 200;   // r-register values
        Reg[5] = 300;   // r-register values

        int[] Mem=new int[400];   // main memory
        char XMem[] = {'l','l','m','a','s','s'};     // six opcodes in XMem
        Mem[0] = 124; Mem[1] = 348; Mem[2] = 246; // six argument lists
        Mem[3] = 468; Mem[4] = 368; Mem[5] = 584; // in main memory
        Mem[104] = 17; Mem[208] = 41;             // memory data values

        // loop over instructions
        for( int PC = 0; PC < 6; PC++ ) {         // fetch-execute cycle
            // f-box
            char head = XMem[PC];
            int  tail = Mem[PC];
            System.out.println("f : Fetched "+ head+"#"+tail+".\n");

            // d-box
            char opc = head;                        // decompose instruction
            System.out.println("d: Set opc to '"+opc+".\n");
            int arg3 = tail % 10;                   // into its opcode and
            tail = tail / 10;                       // its three arguments
            int arg2 = tail % 10;                   // inst = {opc,arg1,...}
            tail = tail / 10;
            int arg1 = tail;

            System.out.println("arg1 "+arg1+" arg2: "+arg2+" arg3: "+arg3+"");



            // all code or equivalent above this line is mandatory

            int D_Out1 = Reg[arg1];                 // You may imitate this style.
            System.out.println("d: Set D_Out1 to "+D_Out1+".\n");
            int D_Out2, dest, value_to_store;
            switch( opc ){
                case 'a':
                case 'm':
                    D_Out2 = Reg[arg2];
                    System.out.println("d: Set D_Out2 to "+D_Out2+".\n");
                    dest = arg3;
                    System.out.println("d: Set dest to f"+dest+".\n");
                    break;
                case 'l':
                    D_Out2 = arg3;
                    break;
                case 's':

                    break;
            }

            // x-box
            int X_Out;
            switch( opc ) {
                case 'a':
                    X_Out= D_Out1+D_Out2;
                    break;
                case 'm':

                    break;
                case 'l':
                    X_Out = D_Out1+D_Out2;
                    break;
                case 's':

                    break;
            }

            // m-box
            int M_Out;
            switch( opc ) {
                case 'l':
                    M_Out= Mem[X_Out];
            }

            // w-box
            switch( opc ){
                case 'l':
                    Reg[arg2]=M_Out;

            }

            System.out.println();
        }                                         // end 'for' loop
    }
/*
f: Fetched l#124.
d: Set opc to 'l'.
d: Set D_Out1 to 100.
d: Set D_Out2 to 4.
d: Set dest to f2.
x: Set X_Out to 104.
m: Set M_Out to 17.
w: Set f2 to 17.
... */

}
