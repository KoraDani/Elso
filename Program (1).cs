using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace ultrabalaton2
{
    class Program
    {
        struct adatok {
            public string nev;
            public int rajtszam;
            public string kat;
            public double[] ido;
            public int tavszaz;
        }
        static double IdoOra(double[] asd) {
            double ora = asd[0] + (asd[1] / 60) + (asd[2] / 3600);
            return ora;
        }
        static void Main(string[] args)
        {
            string[] g = File.ReadAllLines("ub2017egyeni.txt", Encoding.UTF8);
            adatok[] t = new adatok[g.Length - 1];
            int h = g.Length;
            for (int i = 1; i < h; i++)
            {
                string[] f = g[i].Split(';');
                t[i-1].nev = f[0];
                t[i-1].rajtszam = Convert.ToInt32(f[1]);
                t[i-1].kat = f[2];
                string[] b = f[3].Split(':');
                t[i-1].ido = new double[3];
                for (int j = 0; j < 3; j++)
                {
                    t[i-1].ido[j] = Convert.ToInt32(b[j]);
                }
                t[i - 1].tavszaz = Convert.ToInt32(f[4]);
            }
            /*for (int i = 0; i < h-1; i++)
            {
               Console.WriteLine("{0} {1} {2} {3}:{4}:{5} {6}", t[i].nev, t[i].rajtszam, t[i].kat, t[i].ido[0], t[i].ido[1], t[i].ido[2], t[i].tavszaz);

            }*/
            Console.WriteLine("3. feladat: Egyéni indulók száma: {0}",h);
            int nodb = 0;
            for (int i = 0; i < h-1; i++)
            {
                if (t[i].tavszaz == 100 && t[i].kat == "Noi")
                {
                    nodb++;
                }
            }
            Console.WriteLine("4. feladat: Célba érkező Nöi sportolók: {0}", nodb);

            Console.WriteLine("5. feladat: Kérek egy sportoló nevét:");
            string spnev = Console.ReadLine();
            string indultegy = "";
            for (int i = 0; i < h-1; i++)
            {
                if (spnev == t[i].nev)
                {
                    indultegy = "Igen";

                    if (t[i].tavszaz == 100)
                    {
                        Console.WriteLine("Teljesítzette a távot? Igen");
                    }
                    else
                    {
                        Console.WriteLine("Teljesítzette a távot? Nem");
                    }
                }
                else
                {
                    indultegy = "Nem";
                }
            }
            Console.WriteLine("Indult egyéniben a sportoló? "+ indultegy);

            double osszora = 0;
            int fdarab = 0;
            for (int i = 0; i < h-1; i++)
            {
                if (t[i].tavszaz == 100 && t[i].kat == "Ferfi")
                {
                osszora+= IdoOra(t[i].ido);
                    fdarab++;
                }
            }
            Console.WriteLine("7. feladat Átlagos idö {0}", (osszora / fdarab));

            Console.WriteLine("8. feladat: Verseny győztesei");
            Array.Sort(t, (x, y) => x.ido[0].CompareTo(y.ido[0]));
            for (int i = 0; i < h-1; i++)
            {
                if (t[i].tavszaz == 100 && t[i].kat == "Ferfi")
                {
                    Console.WriteLine("\t Férfi {0} {1}:{2}:{3}",t[i].nev,t[i].ido[0], t[i].ido[1], t[i].ido[2]);
                    break;
                }     
            }
            for (int i = 0; i < h - 1; i++)
            {
                if (t[i].tavszaz == 100 && t[i].kat == "Noi")
                {
                    Console.WriteLine("\t Női {0} {1}:{2}:{3}", t[i].nev, t[i].ido[0], t[i].ido[1], t[i].ido[2]);
                    break;
                }
            }
            Console.ReadKey();
        }
    }
}
