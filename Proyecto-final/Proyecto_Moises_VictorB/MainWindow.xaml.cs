using Proyecto_Moises_VictorB.paginas;
using Proyecto_Moises_VictorB.Ventanas;
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

namespace Proyecto_Moises_VictorB
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            
            InitializeComponent();
            
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            myframe.Navigate(new home());
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            myframe.Navigate(new juegos());
        }

        private void Button_Click_2(object sender, RoutedEventArgs e)
        {
            AltaUsuario main = new AltaUsuario();
            main.Show();
        }
    }
}
