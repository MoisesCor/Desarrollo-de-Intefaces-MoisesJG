   M S B A M L   `   `   `  ����R  NProyecto_Moises_VictorB, Version=1.0.0.0, Culture=neutral, PublicKeyToken=nullQ-clr-namespace:Proyecto_Moises_VictorB.paginasProyecto_Moises_VictorB.paginas  5      *    $Proyecto_Moises_VictorB.paginas.home   5      W SPresentationCore, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5      R NSystem.Xaml, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      ?local-clr-namespace:Proyecto_Moises_VictorB.paginas     5        N� Title$
  home��5	       � 	Resources 5
         NeonLabelStyle �� 
TargetType �� Property �� Value �� 
TargetType �� CornerRadius �� 
StartPoint �� EndPoint	 � Color
 � Offset ��Name J� Effect3  -System.Windows.Media.Effects.DropShadowEffect   
BlurRadius   ShadowDepth   Color T� X T� Y � Triggers :� RoutedEvent g� RepeatBehavior �� TargetProperty �� 
TargetName9  3System.Windows.Media.Animation.EasingDoubleKeyFrame O� KeyTime O� Value��%)  &	        �� 5   
   " ��6'   .�5      ��  � ��$ 48(�6)   �� 5       � �� �#FFFFFF6+   �� 5       � ��$ Consolas)�6+   �� 5       � �� 5      �� 5      " ��6&   .R�5      �� $��3q�6!   ���#00FFFF$ 5��6K   ��5      �� 5   "   $	 0,0&�66   $	 1,0&�6G   .��5   &   � $	 #00FFFF��63   $
 0Q�6C   � 5   &   $	 #FF00FF��63   $	
 0.5Q�6C   � 5   &   $	 #00FFFF��63   $
 1Q�6C   5   #   ._�5      �� $ contentPresenter��6/   $��5,0,5,0q�6I    5   "     5   &   $ 20Q�67   $ 0Q�6G   $ #FF00FF��6W   z�5   "   T� 5   &   $ 0Q�69   $ 0Q�6?    5!   "   :� 5"   &   $ Loaded��63   .[�5#   *   �� .��5$   .   �� $ Forever��69   .��5%   2   U� $ (UIElement.Opacity)�6P   $ contentPresenter��6�   .\�5&   6     $ 0:0:0��6K   $	 0.1Q�6[     5'   6   $ 0:0:0.5��6K   $ 1Q�6]     5(   6   $ 0:0:1��6K   $	 0.1Q�6[   5)   3   U� 5*   2   $8 2(UIElement.RenderTransform).(TranslateTransform.X)�6P   $ contentPresenter��6�   .\�5+   6     $ 0:0:0��6K   $ 0Q�6[     5,   6   $ 0:0:0.5��6K   $	 -10Q�6]     5-   6   $ 0:0:1��6K   $ 0Q�6[   5.   3   5/   /   50   +   51   '   53      54      55      57      58      59      .��5;      �� ��5<   
   �� 5=       �� ImageSource$ /paginas/fondo.jpg��6   .+�5?   
   �� #��[  6   $��WELCOME��69    �� Left$	 160��6K   
 �� Top$	 157��6]   $��85��6n   $	��240��6z   $
��Left=�6�   $	��Top=�6�   $��48(�6�   $��Impact)�6�   ���	#FF95FF416�   �� 5@   
   #��[  6   $��PLAYER��69   $	 400��6J   $	 210��6\   $��85��6m   $	��170��6y   $��48(�6�   $
��Left=�6�   $	��Top=�6�   $��Impact)�6�   ���	#FF95FF416�   5A      5B      