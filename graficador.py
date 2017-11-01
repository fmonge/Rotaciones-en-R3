import matplotlib.pyplot as plt
import math

# variables hardcodeadas 
punto = [4,2,5] # x, y, z
size = max(punto) * 1.1 # tamaño grafico + 10% de olgura  

# Base
u = [1, 0, 1]
v = [1, 2, 1]
w = [0, 1, 2]


def iso(punto):
    x = round(punto[1] - punto[0], 2)
    y =  round( -0.5 * (punto[0] + punto[1] - ( 2 * punto[2])), 2)
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

def flecha(punto, fcolor, ecolor):
    x, y = iso(punto)
    ax.arrow(0,0, x, y, 
            head_width=0.5,
            head_length=0.5, 
            fc=fcolor,
            ec=ecolor
            ) 

def arrow2d(puntoA ,puntoB, fcolor, ecolor):
    x1, y1 = iso(puntoA)
    x2, y2 = iso(puntoB)
    ax.arrow(x1,y1, x2, y2, 
            head_width=0.5,
            head_length=0.5, 
            fc=fcolor,
            ec=ecolor
            ) 


def porEscalar(punto, e):
    result = []
    for x in punto:
        result.append(x * e)
    return result


# plano cartesiano 3d
#
eje_x = [size, 0 ,0]
eje_y = [0, size, 0]
eje_z = [0, 0, size]

ax = plt.axes()

# Aristas y vertices
flecha(eje_y,'r','gray')
pos(eje_y,2,"y")
flecha(eje_x,'g','gray')
pos(eje_x,3,"x")
flecha(eje_z,'b','gray')
pos(eje_z,1,"z")
#
# plano cartesiano 3d

arrow2d([0,0,0], porEscalar(u,4),'g','g')
arrow2d([0,0,0], porEscalar(v,3),'g','g')
arrow2d([0,0,0], porEscalar(w,3),'g','g')

arrow2d([0,0,0], u,'b','b')
arrow2d([0,0,0], v,'b','b')
arrow2d([0,0,0], w,'b','b')


# punto
point2d(punto)
pos(punto,3,'p')


#x,y = iso(punto)
#plt.axis([y,y,y,y])
#ax.grid() # fondo cuadriculado

plt.axis([-eje_y[1]*1.1, eje_y[1] * 1.1, -size * 1.1, eje_y[1] * 1.1])
plt.show()
