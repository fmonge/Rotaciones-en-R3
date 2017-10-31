import matplotlib.pyplot as plt
import math

# variables hardcodeadas 
punto_1 = [0,0,5] # x, y, z

def punto(pt):
    x = pt[0]
    y = pt[1]
    z = pt[2]
    # Ajustar en x,y
    x_relativo = round( (x/2) * math.sqrt(3), 2) # tringulo inferior interno
    #y_relativo = round(y*math.sin(60), 2) # tringulo inferior interno
    y_cero = -x_relativo
    y_relativo = round( y_cero + y , 2)# 2*x - y_relativo  ,2) 
    # Ajustar en z:
    #x_relativo = x_relativo - round((z/2)*math.sqrt(3), 2) 
    #y_relativo = y_relativo -  round( z/2, 2)

    print(str(y_relativo))

    plt.plot([x_relativo], [y_relativo], 'ro') # punto en 2,4

    return 1

def pos(eje, pos, text):
    dash_style = (
            (0,20, -15, 30, 10),
            (1, 10, 0, 5, 10),
            (0, 40, 15, 15, 10),
            (1, 20, 30, 60, 10)
            )
    (dd, dl, r, dr, dp) = dash_style[pos]
    ax.text(eje[0], eje[1],text+ ": ("+str(eje[0])+","+str(eje[1])+")",
        withdash=True,
        dashdirection=dd,
        dashlength=dl,
        rotation=r,
        dashrotation=dr,
        dashpush=dp,
        )

def arista(eje, fcolor, ecolor):
    ax.arrow(0,0, eje[0], eje[1], 
            head_width=0.5,
            head_length=0.5, 
            fc=fcolor,
            ec=ecolor
            ) 


size = 10
size_aux  =  round(math.sqrt((size**2)*2),2)

eje_y = [0, size_aux]
eje_x = [size,-size]
eje_z = [-size, -size]

ax = plt.axes()

# Aristas y vertices
arista(eje_y,'r','gray')
pos(eje_y,1,"y")
arista(eje_x,'g','gray')
pos(eje_x,1,"x")
arista(eje_z,'b','gray')
pos(eje_z,3,"z")


# punto
#punto_1 = [3,3,3] # x, y, z
punto(punto_1)

ax.grid() # fondo cuadriculado
plt.axis([-eje_y[1]*1.1, eje_y[1] * 1.1, -size * 1.1, eje_y[1] * 1.1])
plt.show()

