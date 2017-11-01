import matplotlib.pyplot as plt
import math
import np
import numpy as npy

# variables hardcodeadas 
punto = [1,2,3] # x, y, z
size = max(punto) * 1.1 # tamaño grafico + 10% de olgura  

# Base
u = [1, 0, 0]
v = [0, 1, 0]
w = [0, 0, 1]

c = 0  # angulo de giro

def iso(punto):
    x = round(punto[1] - punto[0], 2)
    y = round( -0.5 * (punto[0] + punto[1] - ( 2 * punto[2])), 2)
    return x,y
 
def isoR(punto,c ):
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

def point2d(punto):
    x, y = iso(punto)
    plt.plot(x,y, 'ro') 

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
            ec=ecolor
            ) 

def flechaR(punto, angulo, fcolor, ecolor):
    x, y = isoR(punto, angulo)
    ax.arrow(0,0, x, y, 
            head_width=0.2,
            head_length=0.2, 
            fc=fcolor,
            ec=ecolor
            ) 
    

def porEscalar(punto, e):
    result = []
    for x in punto:
        result.append(x * e)
    return result

def plano():
    # plano cartesiano 3d
    #
    
    # Aristas y vertices
    flecha(eje_y,'gray','gray')
    pos(eje_y,2,"y")
    flecha(eje_x,'gray','gray')
    pos(eje_x,3,"x")
    flecha(eje_z,'gray','gray')
    pos(eje_z,1,"z")
    #
    # plano cartesiano 3d



eje_x = [size, 0 , 0]
eje_y = [0, size, 0]
eje_z = [0, 0, size]
  

ax = plt.axes()
plano()


'''
flecha(porEscalar(u,1.5),'b','b')
flecha( porEscalar(v,1.5),'b','b')
flecha( porEscalar(w,1.5),'b','b')

flecha( u,'g','g')
flecha( v,'g','g')
flecha( w,'g','g')
'''

# punto
point2d(punto)
pos(punto,3,'p')

#ax.clear()

#rote = isoR(punto, rz) 
#punto = rote
#print("rote: " + str(rote))

flechaR( porEscalar(u, 1.5), c , 'b','b')
flechaR( porEscalar(v, 1.5), c, 'b', 'b')
flechaR( porEscalar(w, 1.5), c, 'b', 'b')

flechaR( u, c, 'g', 'g')
flechaR( v, c, 'g', 'g')
flechaR( w, c, 'g', 'g')



#x,y = iso(punto)
#plt.axis([y,y,y,y])
#ax.grid() # fondo cuadriculado

plt.axis([-eje_y[1]*1.1, eje_y[1] * 1.1, -size * 1.1, eje_y[1] * 1.1])
plt.show()
