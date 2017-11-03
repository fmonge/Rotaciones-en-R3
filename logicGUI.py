#import gui as gui1
exec(open("./graficador.py").read())

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
       init(u,v,w       for a,b,c,d in u,v,w,punto:
           if(not(isdigit(a) and isdigit(b) and isdigit(c) and isdigit(d))):
               lblInfo.config(text="Datos incorrectos")
               return
           else:
,grados,punto)
       sombra()
       show()



   except ValueError:
       lblInfo.config(text="Datos incorrectos")


'''
class logicGUI:
    def __init__(self):
        print("import logic")
'''
