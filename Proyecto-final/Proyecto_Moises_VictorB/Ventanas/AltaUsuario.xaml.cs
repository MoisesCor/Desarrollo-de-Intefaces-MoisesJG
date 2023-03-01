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

namespace Proyecto_Moises_VictorB.Ventanas
{

    public partial class AltaUsuario : Window
    {
        public AltaUsuario()
        {
            InitializeComponent();
        }

        private void Border_MouseDown(object sender, MouseButtonEventArgs e)
        {
            if(e.ChangedButton== MouseButton.Left)
            {
                this.DragMove();
            }
            
        }

        void HandleButtonDown(object sender, MouseButtonEventArgs e)
        {
           

            if (e.ButtonState == MouseButtonState.Pressed)
            {
                Close();
            }
            else if (e.ButtonState == MouseButtonState.Released)
            {
              
            }
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            Close();
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            Close();
            MainWindow main = new MainWindow();
            main.Show();
        }
    }
}
