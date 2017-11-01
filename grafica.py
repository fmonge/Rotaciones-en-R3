def pos(eje, pos):
    dash_style = (
            (0,20, -15, 30, 10),
            (1, 30, 0, 15, 10),
            (0, 40, 15, 15, 10),
            (1, 20, 30, 60, 10))

    (dd, dl, r, dr, dp) = dash_style[pos]
    ax.text(eje[0], eje[1],"("+str(eje[0])+","+str(eje[1])+")",
        withdash=True,
        dashdirection=dd,
        dashlength=dl,
        rotation=r,
        dashrotation=dr,
        dashpush=dp,
        )

