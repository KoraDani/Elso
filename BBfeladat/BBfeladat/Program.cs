using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BBfeladat
{
    class Program
    {
        static void Main(string[] args)
        {
            //1. Feladat
            Console.WriteLine("Adj meg két számot");
            int a = Convert.ToInt32(Console.ReadLine());
            int b = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("A két szám hányadosa {0}",(a/b));
            Console.WriteLine("A kát szám maradéka {0}",(a%b));

            //2. Feladat
            Console.WriteLine("Kérem adjon meg két befogót: ");
            int x = Convert.ToInt32(Console.ReadLine());
            int y = Convert.ToInt32(Console.ReadLine());
            double kiszamol = Math.Pow(x, 2)+ Math.Pow(y, 2);
            Console.WriteLine("Az átfogó értéke {0:0.00}", Math.Sqrt(kiszamol));

            //3. Feladat
            Console.WriteLine("Kérem adjon meg egy érdemjegyet");
            int erdemjegy = Convert.ToInt32(Console.ReadLine());
            switch (erdemjegy)
            {
                case 5:
                    Console.WriteLine("Jeles");
                    break;
                case 4:
                    Console.WriteLine("Jó");
                    break;
                case 3:
                    Console.WriteLine("Közepes");
                    break;
                case 2:
                    Console.WriteLine("Elégséges");
                    break;
                case 1:
                    Console.WriteLine("Elégtelen");
                    break;
                default:
                    Console.WriteLine("Ilyen érdemjegy nem létezik");
                    break;
            }

            //4. Feladat
            int parosdb = 0;
            Random rnd = new Random();
            int[] t = new int[5];
            for (int i = 0; i < t.Length; i++)
            {
                t[i] = rnd.Next(1,51);
            }
            for (int i = 0; i < t.Length; i++)
            {
                if (t[i] % 2 == 0)
                {
                    parosdb++;
                }
            }
            Console.WriteLine("{0} páros számot generáltunk", parosdb);
            Console.ReadKey();
        }
    }
}
