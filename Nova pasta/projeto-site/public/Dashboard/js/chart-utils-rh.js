function insertIntoChart(chart, data) {

    const contador = { feliz: 0, neutro: 0, triste: 0 }

    for (const item of data) {
        const {
            sentimento: feeling,
            momentoRelato: readDate
        } = item;

        contador[feeling.toLowerCase()] = contador[feeling.toLowerCase()] + 1


    }

    chart.data.datasets[0].data = [contador.feliz || 0, contador.neutro || 0, contador.triste || 0]

    chart.update();
}
