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
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Proyecto_Moises_VictorB.paginas
{
    /// <summary>
    /// Lógica de interacción para juegos.xaml
    /// </summary>
    public partial class juegos : Page
    {
        public juegos()
        {
            InitializeComponent();
        }

        private void AbrirText(object sender, RoutedEventArgs e)
        {
            texto1.Visibility = Visibility.Visible;
            boton1.Visibility = Visibility.Hidden;
            boton1.IsEnabled = false;
        }

        private void AbrirText2(object sender, RoutedEventArgs e)
        {
            texto2.Visibility = Visibility.Visible;
            boton2.Visibility = Visibility.Hidden;
            boton2.IsEnabled = false;
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            MainWindow main= new MainWindow();
            main.Show();

        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            MainWindow main = new MainWindow();
            main.Show();
        }
    }
}
