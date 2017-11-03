import matplotlib.pyplot as plt
import math
import np
import numpy as npy

import sys
 
print("Número de parámetros: ", len(sys.argv))
print("Lista de argumentos: ", sys.argv)
var =  sys.argv[1:]

# variables hardcodeadas 
punto = [1,2,3] # x, y, z
#x0 = y0 = 0
size = max(punto) * 2 # tamaño grafico + 200% de olgura  
# Base
u = [1, 0, 1]
v = [0, 1, 1]
w = [0, 0, 1]
grados =110 #angulo de giro

u = list(map(int, var[0].split(',')))
v = list(map(int, var[1].split(',')))
w = list(map(int, var[2].split(',')))
punto = list(map(int, var[3].split(',')))
print(punto)
size = max(punto) * 1.5
grados = int(var[4])


def variables():
    try:
        u = list(map(int, var[0].split(',')))
        v = list(map(int, var[1].split(',')))
        w = list(map(int, var[2].split(',')))
        punto = list(map(int, var[3].split(',')))
        print(punto)
        size = max(punto) * 2
        grados = int(var[4])
    except ValueError:
        print("Datos incorrectos")


#variables()

#     
## variables hardcodeadas 
#punto = [1,2,3] # x, y, z
##x0 = y0 = 0
#size = max(punto) * 2 # tamaño grafico + 200% de olgura  
## Base
#u = [1, 0, 1]
#v = [0, 1, 1]
#w = [0, 0, 1]
#grados =110 #angulo de giro


def iso(punto):
    x = round(punto[1] - punto[0], 2)
    y = round( -0.5 * (punto[0] + punto[1] - ( 2 * punto[2])), 2)
    return x,y
 
def isoR(punto, c):
    '''
        putno = x,y,z
        c= angulo
    '''
    rz = [
          [math.cos(c), - math.sin(c), 0],
          [math.sin(c), math.cos(c), 0],
          [0, 0, 1]
         ]

    punto = npy.array(punto)
    rz = npy.array(rz)
    return iso(rz.dot(punto.T).T.tolist())

def point2d(punto, grado, color): # ro = rojo; o = azul
    x, y = isoR(punto, grado)
    plt.plot(x, y, color) 

def point2dOriginal(punto, color): # ro = rojo; o = azul
    x0,y0 = x, y = iso(punto)
    plt.plot(x, y, color) 



def pos(punto, pos, text):
    x, y = iso(punto)
    dash_style = (
                  (0,20, -15, 30, 10),  (1, 35, 0, 5, 15),
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
            head_width=0.3,
            head_length=0.3, 
            fc=fcolor,
            ec=ecolor,
            linestyle='-'
            ) 

def flechaR(punto, angulo, fcolor, ecolor):
    x, y = isoR(punto, angulo)
    ax.arrow(0,0, x, y, 
            head_width=0.2,
            head_length=0.2, 
            fc=fcolor,
            ec=ecolor,
            linestyle='-'
            ) 
def flechaPunto(a,b, angulo, fcolor, ecolor):
    x1, y1 = isoR(a, angulo)  
    x2, y2 = isoR(b, angulo)
    ax.arrow(x1, y1, x2, y2, 
            head_width=0,
            head_length=0, 
            fc=fcolor,
            ec=ecolor,
            linestyle=':'
            ) 

def flechaPuntoOriginal(a,b, fcolor, ecolor):
    x1, y1 = iso(a)  
    x2, y2 = iso(b)
    ax.arrow(x1, y1, x2, y2, 
            head_width=0,
            head_length=0, 
            fc=fcolor,
            ec=ecolor,
            linestyle=':'
            ) 
     
def porEscalar(punto, e):
    result = []
    for x in punto:
        result.append(x * e)
    return result

def plano():
    # plano cartesiano 3d
    # Aristas y vertices
    flecha(eje_y,'gray','gray')
    pos(eje_y,2,"y")
    flecha(eje_x,'gray','gray')
    pos(eje_x,3,"x")
    flecha(eje_z,'gray','gray')
    pos(eje_z,1,"z")

def lineasAlPunto():
    flechaPunto(eje_y, 'gray','gray')
    flechaPunto(eje_x, 'gray','gray')
    flechaPunto(eje_z, 'gray','gray')

def sombra():
    # el plano en gris como una sombra de referencia
    plano()
    x,y,z = punto
    # punto original
    point2dOriginal(punto, 'ro')
    pos(punto, 3, 'p')
    # (a,b, angulo, fcolor, ecolor):
    #x, y, z = punto
    
    flechaPuntoOriginal([x, y, 0], [0, -y, 0], 'gray', 'gray')
    flechaPuntoOriginal([x, y, 0], [-x, 0, 0], 'gray', 'gray')
    flechaPuntoOriginal([x, y, 0], [0, 0, z], 'gray', 'gray')


def  init(u1, v1, w1, grados1, punto1):
    #ax.clear()

    u = u1
    v = v1
    w = w1
    grados = grados1
    punto = punto1
    ax.clear()
    print("Generando en 2D")




eje_x = [size, 0 , 0]
eje_y = [0, size, 0]
eje_z = [0, 0, size]


def planoRotado():
    flechaR( porEscalar(u, 2), grados, 'b','b')
    flechaR( porEscalar(v, 2), grados, 'b', 'b')
    flechaR( porEscalar(w, 3), grados, 'b', 'b')
    
    flechaR( u, grados, 'g', 'g')
    flechaR( v, grados, 'g', 'g')
    flechaR( w, grados, 'g', 'g')

    point2d(punto, grados, 'ro')
    pos(punto, 3, 'p')


    # punto 
    #x, y, z = punto
    #flechaPunto([x, y, 0], [0, -y, 0], grados, 'g', 'g')
    #flechaPunto([x, y, 0], [-x, 0, 0], grados, 'r', 'g')
    #flechaPunto([x, y, 0], [0, 0, z], grados, 'g', 'g')


def show():
    plt.axis([-eje_y[1]*1.1, eje_y[1] * 1.1, -size * 1.1, eje_y[1] * 1.1])
    plt.show()


ax = plt.axes()
#ax.clear()

init(u,v,w,grados,punto)
sombra()
planoRotado()
show()
