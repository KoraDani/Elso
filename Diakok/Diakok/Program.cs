using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Diakok
{
    struct Diakok
    {
        public string Nev;
        public int Osztalyzat;
        public bool Hianyzik;
    }
    class Program
    {
        static Diakok[] diak = new Diakok[34];
        
        static void Beolvasas()
        {
            StreamReader sr = new StreamReader("diakok.txt",Encoding.UTF8);
            int index = 0;
            sr.ReadLine();
            while (sr.Peek() > -1)
            {
                var sor = sr.ReadLine().Split(';');
                for (int i = 0; i < diak.Length; i++)
                {
                    if (diak[index].Nev == diak[i].Nev)
                    {
                        diak[index].Nev = sor[0];
                    }
                }
                diak[index].Osztalyzat = 0;
                diak[index].Hianyzik = false;
                index++;
            }
        }

        static void Jegyek()
        {
            Random rnd = new Random();
            int index = 0;
            while (index != diak.Length)
            {
                diak[index].Osztalyzat = rnd.Next(1, 6);
                index++;
            }
        }

        static void OsztLetszam()
        {
            Console.WriteLine("Az osztály létszáma: " + diak.Length);
        }

        static void Atlag()
        {
            int ossz = 0;
            float atlag = 0;
            foreach (var item in diak)
            {
                ossz += item.Osztalyzat;
            }
            atlag =(float) ossz / diak.Length;
            Console.WriteLine("Az osztály átlag " + atlag);
        }

        static void KiMutatas()
        {
            int egy = 0, ketto = 0, harom = 0, negy = 0, ot = 0;
            for (int i = 0; i < diak.Length; i++)
            {
                switch (diak[i].Osztalyzat)
                {
                    case 1:
                        egy++;
                        break;
                    case 2:
                        ketto++;
                        break;
                    case 3:
                        harom++;
                        break;
                    case 4:
                        negy++;
                        break;
                    case 5:
                        ot++;
                        break;
                    default:
                        break;
                }
            }
            Console.WriteLine("Egyesből {0}db " +
                "\nKettesből {1}db " +
                "\nHármasból {2}db " +
                "\nNégyesből {3}db " +
                "\nÖtösből {4}db"
                ,egy,ketto,harom,negy,ot);
        }

        static void RosszJegy()
        {
            for (int i = 0; i < diak.Length; i++)
            {
                if (diak[i].Osztalyzat.Equals(1))
                {
                    diak[i].Hianyzik = true;
                }
            }
        }

        static void FajIras()
        {
            FileStream fs = new FileStream(("kreta" + DateTime.Now.ToShortDateString() + ".csv"), FileMode.Create);
            StreamWriter sw = new StreamWriter(fs, Encoding.Default);
            sw.WriteLine("Tanuló;Érdemjegy;Hiányzás");
            for (int i = 0; i < diak.Length; i++)
            {
                sw.WriteLine(diak[i].Nev + ";" + diak[i].Osztalyzat + ";" + (diak[i].Hianyzik ? "IGAZ" : "HAMIS"));
            }
            sw.Close();
        }
        static void Main(string[] args)
        {
            Console.WriteLine("1. feladat\n");
            Beolvasas();
            Console.WriteLine("2. feladat\n");
            Jegyek();
            Console.WriteLine("3. feladat");
            OsztLetszam();
            Console.WriteLine("\n4. feladat");
            Atlag();
            Console.WriteLine("\n5. feladat");
            KiMutatas();
            Console.WriteLine("\n6. feladat\n");
            RosszJegy();
            Console.WriteLine("7-8. feladat\n");
            FajIras();
            Console.ReadKey();
        }
    }
}
