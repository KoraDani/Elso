using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ubalaton
{
    class Program
    {
        struct ub
        {
            public string versenyzo;
            public int rajtszam;
            public string kategoria;
            public double[] versenyido;
            public int tavszazalek;

        }
        //6
        static double IdoOra(double[] kistomb)
        {
            double oraban = kistomb[0] + kistomb[1] / 60 + kistomb[2] / 3600;
            return oraban;
        }

        static void Main(string[] args)
        {
            string[] g = File.ReadAllLines("ub2017egyeni.txt");

            int h = g.Length;
            int hm = g.Length - 1;

            List<ub> u = new List<ub>(g.Length - 1);

            for (int i = 1; i < h; i++)
            {
                string[] f = g[i].Split(';');
                ub w = new ub();
                w.versenyzo = f[0];
                w.rajtszam = Convert.ToInt32(f[1]);
                w.kategoria = f[2];
                string[] b = f[3].Split(':');
                w.versenyido = new double[b.Length];
                for (int j = 0; j < b.Length; j++)
                {
                    w.versenyido[j] = Convert.ToDouble(b[j]);
                }
                w.tavszazalek = Convert.ToInt32(f[4]);

                u.Add(w);
            }

            //3
            Console.WriteLine("3. Feladat: Egyéni indulók: {0}", h - 1);

            //4
            int nok = 0;
            for (int i = 1; i < h - 1; i++)
            {
                if (u[i].kategoria == "Noi" && u[i].tavszazalek == 100)
                {
                    nok++;
                }
            }


            Console.WriteLine("4. Feladat: Célba érkező női sportolók: {0}", nok);

            //5
            Console.Write("5. Feladat: Kérem a sportoló nevét: ");
            string nev = Console.ReadLine();
            bool van = false;
            bool tav = false;
            for (int i = 0; i < h - 1; i++)
            {
                if (u[i].versenyzo == nev)
                {
                    van = true;

                    if (u[i].tavszazalek == 100)
                    {
                        tav = true;
                    }

                }


            }
            if (van == true)
            {

                //Acsadi Lajos
                Console.WriteLine("     Indult egyéniben a sportoló? Igen");
                if (tav == true)
                {
                    Console.WriteLine("     Teljesítette a távot? Igen");

                }
            }
            else
            {
                Console.WriteLine("     Indult egyéniben a sportoló? Nem");
            }

            //7
            double osszi = 0;
            int ferfi = 0;
            for (int i = 0; i < hm; i++)
            {
                if (u[i].kategoria == "Ferfi" && u[i].tavszazalek == 100)
                {
                    ferfi++;
                    osszi += IdoOra(u[i].versenyido);

                }
            }

            Console.WriteLine("7. Feladat: Átlagos idő: {0}", osszi / ferfi);
            //BABY YODA

            //8
            int sorszf = 0;
            int sorszn = 0;
            for (int i = 0; i < hm; i++)
            {
                if (u[i].kategoria == "Ferfi" && u[i].tavszazalek == 100)
                {
                    sorszf = i;
                    break;

                }
                if (u[i].kategoria == "Noi" && u[i].tavszazalek == 100)
                {
                    sorszn = i;
                    break;

                }

            }

            double min = IdoOra(u[sorszf].versenyido);
            double minno = IdoOra(u[sorszn].versenyido);

            int nsrsz = 0;
            int fsrsz = 0;
            for (int i = 0; i < hm; i++)
            {
                if (u[i].kategoria == "Ferfi" && u[i].tavszazalek == 100)
                {
                    if (min > IdoOra(u[i].versenyido))
                    {
                        min = IdoOra(u[i].versenyido);
                        fsrsz = i;
                    }
                }

                if (u[i].kategoria == "Noi" && u[i].tavszazalek == 100)
                {
                    if (minno > IdoOra(u[i].versenyido))
                    {
                        minno = IdoOra(u[i].versenyido);
                        nsrsz = i;
                    }
                }
            }
            Console.WriteLine("8. Feladat: Verseny győztesei: " + "(" + fsrsz + ".)" + u[fsrsz].versenyzo + "       " + "/n Nők: " + u[nsrsz].versenyzo);


            Console.ReadLine();

        }
    }
}

