import matplotlib.pyplot as plt
import math

# variables hardcodeadas 
punto = [40,20,50] # x, y, z
size = max(punto) * 1.1 # un 10% de olgura 

def iso(punto):
    x = round(punto[1] - punto[0],2)
    y =  round( -0.5*(punto[0] + punto[1] - ( 2 * punto[2])) ,2)
    return x,y
    

def point2d(punto):
    x, y = iso(punto)
    plt.plot(x,y, 'ro') 


def pos(punto, pos, text):
    x, y = iso(punto)
    dash_style = (
            (0,20, -15, 30, 10),  (1, 10, 0, 5, 10),
            (0, 40, 15, 15, 10),  (1, 20, 30, 60, 10)
            )
    (dd, dl, r, dr, dp) = dash_style[pos]
    a = str(round(punto[0], 2))
    b = str(round(punto[1], 2))
    c=  str(round(punto[2], 2))
    ax.text(x, y, text + ": (" + a +"," + b+ "," + c + ")" ,
        withdash=True,
        dashdirection=dd,
        dashlength=dl,
        rotation=r,
        dashrotation=dr,
        dashpush=dp,
        )

def arrow2d(punto, fcolor, ecolor):
    x, y = iso(punto)
    ax.arrow(0,0, x, y, 
            head_width=0.5,
            head_length=0.5, 
            fc=fcolor,
            ec=ecolor
            ) 


#size_aux  = round(math.sqrt((size**2)*2),2)
eje_x = [size, 0 ,0]
eje_y = [0, size, 0]
eje_z = [0, 0, size]

ax = plt.axes()

# Aristas y vertices
arrow2d(eje_y,'r','gray')
pos(eje_y,1,"y")
arrow2d(eje_x,'g','gray')
pos(eje_x,1,"x")
arrow2d(eje_z,'b','gray')
pos(eje_z,1,"z")


# punto
#punto_1 = [3,3,3] # x, y, z
point2d(punto)

ax.grid() # fondo cuadriculado
x,y = iso(punto)
#plt.axis([y,y,y,y])
plt.axis([-eje_y[1]*1.1, eje_y[1] * 1.1, -size * 1.1, eje_y[1] * 1.1])
plt.show()
