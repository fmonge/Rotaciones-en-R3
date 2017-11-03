from tkinter import *
from tkinter import ttk

#import logicGUI as lg

import os

#exec(open("./logicGUI.py").read())
exec(open("./graficador.py").read())

#init([1,0,0],[0,1,0],[0,0,1],0,[1,2,3])

def dibujar():
   try:
       grados = int(gradosText.get())
       u = list(map(int, baseUText.get().split(',')))
       v = list(map(int, baseVText.get().split(',')))
       w = list(map(int, baseWText.get().split(',')))
       punto = list(map(int, basePuntoText.get().split(',')))
       print(u)
       print(v)
       print(w)
       print(punto)
       print(grados)
       lblInfo.config(text="Generando grafico")
       init(u,v,w,grados,punto)
       sombra()
       show()

   except ValueError:
       lblInfo.config(text="Datos incorrectos")


def _quit():
    root.quit()     # stops mainloop
    root.destroy()  # this is necessary on Windows to prevent
    # Fatal Python Error: PyEval_RestoreThread: NULL tstate


root = Tk()  # crea la ventana 
root.title("Rotaciones en R3")
root.geometry('210x133')
root.configure(bg = 'gray')

frame = Frame(root)
frame.grid(column=0, row=0, padx=(0,0), pady=(0,0))
frame.columnconfigure(0, weight=1) # relativo
frame.rowconfigure(0, weight=1)

# labels
lblGrados = Label(frame, text="Grados:")
lblGrados.grid(column=2, row=2, sticky=(W,E))
# base
lblBase = Label(frame, text="Bases")
lblBase.grid(column=2, row=3, sticky=(W,E))
lblU = Label(frame, text="U:")
lblU.grid(column=2, row=4, sticky=(W,E))
lblV = Label(frame, text="V:")
lblV.grid(column=2, row=5, sticky=(W,E))
lblW = Label(frame, text="W:")
lblW.grid(column=2, row=6, sticky=(W,E))

lblPunto = Label(frame, text="Punto:")
lblPunto.grid(column=2, row=7, sticky=(W,E))

lblInfo= Label(frame, text="")
lblInfo.grid(column=4, row=2, sticky=(W,E))


# variables funcionales
grados = u = v = w =  punto = ''

# Input fields
gradosText = Entry(frame, width=10, textvariable=grados)
gradosText.grid(column=3, row=2)
baseUText = Entry(frame, width=10, textvariable=grados)
baseUText.grid(column=3, row=4)
baseVText = Entry(frame, width=10, textvariable=grados)
baseVText.grid(column=3, row=5)
baseWText = Entry(frame, width=10, textvariable=grados)
baseWText.grid(column=3, row=6)
basePuntoText = Entry(frame, width=10, textvariable=grados)
basePuntoText.grid(column=3, row=7)


# botons

boton = Button(frame, text="Dibujar", command=dibujar) # si le pone () no sirve
boton.grid(column=4, row=6)

btnSalir = Button(frame, text="Salir", command=_quit) # si le pone () no sirve
btnSalir.grid(column=4, row=7)









#btnOk = Button(root, text="Rotar")


#ttk.Button(root, text='Salir', command=quit)#.pack(side=BOTTOM)


#lblGrados.pack#(side=TOP)
#btnOk.pack()
root.mainloop()

'''
class gui:
    def __init_(self):
        print("")
'''



