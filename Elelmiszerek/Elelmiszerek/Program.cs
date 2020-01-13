using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Elelmiszerek
{
    class Program
    {
        struct adatok
        {
            public string megnevezes;
            public int energiatart;
            public DateTime gyartasdate;
            public double egysegar;
            public int mennyiseg;
            public string kat;
            public string dietas;
            

        }
        static void Main(string[] args)
        {
            string[] g = File.ReadAllLines("elelmiszerek.csv");
            adatok[] t = new adatok[g.Length - 1];
            for (int i = 1; i < g.Length - 1; i++)
            {
                string[] f = g[i].Split(';');
                t[i].megnevezes = f[0];
                t[i].energiatart = Convert.ToInt32(f[1]);
                t[i].gyartasdate = Convert.ToDateTime(f[2]);
                t[i].egysegar = Convert.ToDouble(f[3]);
                t[i].mennyiseg = Convert.ToInt32(f[4]);
                t[i].kat = f[5];
                t[i].dietas = f[6];

            }
            /* for (int i = 0; i < g.Length; i++)
             {
                 Console.WriteLine("{0}{1}{2}{3}{4}{5}{6}{7}", t[i].megnevezes, t[i].energiatart, t[i].gyartasdate, t[i].ora,t[i].egysegar,t[i].mennyiseg,t[i].kat,t[i].dietas);
             }*/
            Console.WriteLine("3. Feladat Élelmiszerek száma: {0}", g.Length - 1);
            double edes = t[0].egysegar;
            int index = 0;
            for (int i = 0; i < g.Length - 1; i++)
            {
                if (t[i].kat == "édesség")
                {
                    if (edes < t[i].egysegar)
                    {
                        edes = t[i].egysegar;
                        index = i;
                    }
                }
            }
            Console.WriteLine("4. feladat A legdrágább élelmiszer: \n Megnevezeés {0} \n Gyártás ideje {1} \n Egységár {2} Ft", t[index].megnevezes, t[index].gyartasdate, t[index].egysegar);
            int db18 = 0;
            for (int i = 0; i < g.Length - 1; i++)
            {
                if (t[i].gyartasdate <= Convert.ToDateTime("2018.09.01") && t[i].gyartasdate >= Convert.ToDateTime("2018.09.30"))
                {
                    db18++;
                }
            }
            Console.WriteLine("5. feladat A 2018.szeptemberben gyártott áruk darabszáma:{0}", db18);
            string sajt = "Nincs";
            for (int i = 0; i < g.Length - 1; i++)
            {
                if (t[i].kat == "tej, tejtermék")
                {
                    sajt = "Van";
                    break;
                }
            }
            Console.WriteLine("{0} az árucikkek közt sajt", sajt);
            double osszar = 0;
            for (int i = 0; i < g.Length - 1; i++)
            {
                osszar += t[i].egysegar % 330;
            }
            Console.WriteLine("9. feladat Az üzlet árukészletének értéke : {0:0.00}", osszar);
            Console.ReadKey();
        }
    }
}
