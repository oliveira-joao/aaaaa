function insertIntoChart(registros, data) {

    let averageCpuUsage = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    let averageRamUsage = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    let averageDiskUsage = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    let averagePerHour = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0];

    registros = registros.filter(function (registro) {
        data = data ? data.split('/').reverse().join('-') : new Date(Date.now()).toJSON().substring(0, 10)

        return registro.horarioLeitura.startsWith(data)
    })

    for (const item of registros) {
        const {
            porcentagemUsoCPU: cpuUsage,
            porcentagemUsoRAM: ramUsage,
            porcentagemUsoDisco: diskUsage,
            horarioLeitura: readDate,
            fkFuncionario: _idWorker
        } = item;

        const formattedReadDate = new Date(readDate);

        const hours = formattedReadDate.getUTCHours();

        const readTime = hours >= 10 ? `${hours}:00` : `0${hours}:00`;

        const indexOfTime = chartGraph.data.labels.indexOf(readTime);

        if (indexOfTime === -1) continue;

        averageCpuUsage[indexOfTime] += cpuUsage;
        averageRamUsage[indexOfTime] += ramUsage;
        averageDiskUsage[indexOfTime] += diskUsage;
        averagePerHour[indexOfTime] += 1;
    }

    function calculateAverage(time, index) {
        const averageValue = averagePerHour[index];

        if (time === 0) return 0;

        return (time / averageValue).toFixed(2);
    }

    chartGraph.data.datasets[0].data = averageCpuUsage.map(calculateAverage);
    chartGraph.data.datasets[1].data = averageRamUsage.map(calculateAverage);
    chartGraph.data.datasets[2].data = averageDiskUsage.map(calculateAverage);

    chartGraph.update();
}