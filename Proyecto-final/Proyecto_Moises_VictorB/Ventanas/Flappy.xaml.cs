using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using System.Windows.Threading;
using static System.Formats.Asn1.AsnWriter;

namespace Proyecto_Moises_VictorB.Ventanas
{
    /// <summary>
    /// Lógica de interacción para Flappy.xaml
    /// </summary>
    public partial class Flappy : Window
    {
        /*Esto es como declarar atributos en java cualquier método en este caso función del juego
         puede acceder a ellas y modificarlas o usar si valor*/
        //creamos temporizaor
        DispatcherTimer temporizadorJuego = new DispatcherTimer();
        //creamos gravedad y le damos como valor 8 (Esto es como haciamos en unity para controlar el salto), es decir para que el pajaro caiga al suelo simulamos gravedad
        int gravity = 8;

        //creamos una variable para los puntos, cada vez que pase entre las tuberias pues tendra asignado unos puntos
        double puntos;

        //para detectar la colision nos creamos la siguiente variable
        Rect FlappyRect;

        //Nos creamos un boolean para comprobar si es gameover o sigue en partida
        Boolean gameOver;

        public Flappy()
        {
            InitializeComponent();
            /*Le pasamos los eventos y el tiempo e iniciamos el juego*/
            temporizadorJuego.Tick += FlappyEventosTiempo;
            temporizadorJuego.Interval = TimeSpan.FromMilliseconds(20);
            StartGame();
        }
        /*Este evento es el del tiempo una vez iniciado el juego todo pasa por esta función*/
        private void FlappyEventosTiempo(object sender, EventArgs e)
        {
            txtScore.Content = "Puntos: " + puntos;//sumamos puntuación

            //a nuestra variable para controlar la colisión le estamos dando los valores de todas las posiciones del pajaro para que lo controle
            //para la altura lo ponemos a mano, porque la foto es cuadrada, entonces intentamos como redondearlo para cuando golpe q no parezca trampa del juego
            FlappyRect = new Rect(Canvas.GetLeft(pajaroVolador), Canvas.GetTop(pajaroVolador), pajaroVolador.Width - 12, pajaroVolador.Height);

            //Damos al pajaro la posición de la gravedad para que siempre le empuje para abajo
            Canvas.SetTop(pajaroVolador, Canvas.GetTop(pajaroVolador) + gravity);

            if (Canvas.GetTop(pajaroVolador) < -30 || Canvas.GetTop(pajaroVolador) + pajaroVolador.Height > 460)
            {
                FinJuego();// en este if comprobamos si el pajaro se ha  pasado de los limites de la pantalla entonces lo paramos
            }


            /*Este bucle es el que se encarga de recorrer las imagenes por etiquetas
             lo mueve 5 pixeles a la izquierda*/
            foreach (var x in MyCanvas.Children.OfType<Image>())
            {
                if ((string)x.Tag == "obs1" || (string)x.Tag == "obs2" || (string)x.Tag == "obs3")
                {   
                    //movemos la tubería
                    Canvas.SetLeft(x, Canvas.GetLeft(x) - 5);

                    //comprobamos donde esta, si es menos la volvemos a poner en su posicion
                    //y nos sumanos 5 puntos
                    if (Canvas.GetLeft(x) < -100)
                    {
                        Canvas.SetLeft(x, 800);

                        puntos += .5;
                    }

                    /*Creamos y configuramos un colisionador, si se toca pues fin*/
                    Rect PillarHitBox = new Rect(Canvas.GetLeft(x), Canvas.GetTop(x), x.Width, x.Height);

                    if (FlappyRect.IntersectsWith(PillarHitBox))
                    {
                        FinJuego();
                    }
                }

                //esto como lo anterior pero para las nubes
                if ((string)x.Tag == "nubes")
                {
                    Canvas.SetLeft(x, Canvas.GetLeft(x) - 1);

                    if (Canvas.GetLeft(x) < -250)
                    {
                        Canvas.SetLeft(x, 550);

                        puntos += .5;
                    }

                }


            }


        }
        /*Con esta función lo que hacemos es darle a la tecla espacio y la letra R una función
         la recojemos con el evento KeyEventArgs, este evento se lo hemos dado a la ventana (canvas)
        Lo que hace que si pulsamos espacio rota al pajaro y resta La gravedad para q suba
        y luego si la tecla es r y ademas el gameOver es verdadero pues vuelve a inniciar el juego*/
        private void KeyIsDown(object sender, KeyEventArgs e)
        {
            if (e.Key == Key.Space)
            {   //dividimos la imagen en dos para dar conn el centro
                pajaroVolador.RenderTransform = new RotateTransform(-20, pajaroVolador.Width / 2, pajaroVolador.Height / 2);
                gravity = -8;
            }

            if (e.Key == Key.R && gameOver == true)
            {
                StartGame();
            }
        }
        /*Esta función es paara que cuando no tenga presionada las teclas vuelva a la posición original y vuelva la gravedad*/
        private void KeyIsUp(object sender, KeyEventArgs e)
        {
            pajaroVolador.RenderTransform = new RotateTransform(5, pajaroVolador.Width / 2, pajaroVolador.Height / 2);

            gravity = 8;
        }

        /*Cargamos los objetos de la escena (juego) su posición , iniciamos los puntos a 0 etc..*/
        private void StartGame()
        {
            MyCanvas.Focus();

            int temp = 300;//lo usamos para las imagnenes de las nubes para que queden distanciadas

            puntos = 0;

            gameOver = false;

            Canvas.SetTop(pajaroVolador, 190);// restablecemos la imagen del pajaro para cuando se inicia, es decir lo estamos colocando en la imagen

            /*Creamos una variable x, donde guardamos los objetos en ella, es decir en este caso las imagenes
             por eso decimos, x va ser hijas del canvas del tipo imagen, estamos recorriendo las imagenes en bucle*/
            foreach (var x in MyCanvas.Children.OfType<Image>())
            {   /*Con estos if que es el grupo que hemos dado a cada grupo de tuberías, lo que hacemos es dar el posicionamiento
                 inicial de cada cosa */
                if ((string)x.Tag == "obs1")
                {
                    Canvas.SetLeft(x, 500);
                }
                if ((string)x.Tag == "obs2")
                {
                    Canvas.SetLeft(x, 800);
                }
                if ((string)x.Tag == "obs3")
                {
                    Canvas.SetLeft(x, 1100);
                }

                if ((string)x.Tag == "nubes") //esto es para las nubes y lo hacemos así para que no se pisen entre ellas, cuando se repite para la segunda pues tiene 300+800, la primera tiene 300+300
                {
                    Canvas.SetLeft(x, 300 + temp);
                    temp = 800;
                }
            }
            //Una vez todo colocado en su sitio pues empezamos las acciones que pasan en el juego, es decir que se muevan las nubes y tubos
            temporizadorJuego.Start();
        }

        private void FinJuego()
        {
            temporizadorJuego.Stop();
            gameOver = true;
            txtScore.Content += " Game Over!!! Presiona R para reiniciar.";

        }
    }
}

