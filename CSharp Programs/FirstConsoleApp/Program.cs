using System;
using System.ComponentModel;

namespace FirstConsoleApp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //char for a single alphanumeric character
            char c = 'a';
            Console.WriteLine(c);
            Console.WriteLine(char.MinValue);
            Console.WriteLine(char.MaxValue);

            //string for words, phrases, or any alphanumeric data for presentation, not calculation
            string str = "Hello!1";
            Console.WriteLine(str);

            //int for a whole numbe
            int x =12, y=-15; int z = 00;
            Console.Write(x+" "+y+" "+z+"\n");

            int age = 26;
            Console.WriteLine(age);
            Console.WriteLine(int.MinValue);
            Console.WriteLine(int.MaxValue);

            long mobile = 859674894578;
            Console.WriteLine(mobile);
            Console.WriteLine(long.MinValue);
            Console.WriteLine(long.MaxValue);

            //decimal for a number with a fractional component
            float salary = 23.12F;
            Console.WriteLine(salary);
            Console.WriteLine(float.MinValue);
            Console.WriteLine(float.MaxValue);

            double negative = -55.23D;
            Console.WriteLine(negative);
            Console.WriteLine(double.MinValue);
            Console.WriteLine(double.MaxValue);

            decimal money = 25.12M;
            Console.WriteLine(money);
            Console.WriteLine(decimal.MinValue);
            Console.WriteLine(decimal.MaxValue);

            Console.WriteLine("0.1+0.2 == 0.3? "+(0.1 +0.2 == 0.3));

            //bool for a true/false value
            bool b = false;
            Console.WriteLine(34.40M);

            Console.WriteLine(5 / 10);

            //Console.ReadKey();
        }
    }
}
