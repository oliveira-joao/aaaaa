'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Leitura = sequelize.define('Leitura',{
		idLeitura: {
			field: 'idFuncionario',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},		
		porcentagemUsoCPU: {
			field: 'porcentagemUsoCPU',
			type: DataTypes.INTEGER,
			allowNull: false
		},
		porcentagemUsoRAM: {
			field: 'porcentagemUsoRAM',
			type: DataTypes.INTEGER,
			allowNull: false
		},
		porcentagemUsoDisco: {
			field: 'porcentagemUsoDisco',
			type: DataTypes.INTEGER,
			allowNull: false
		},
		horarioLeitura: {
			field: 'horarioLeitura',
			type: DataTypes.DATE,
			allowNull: false
		},
        fkComputador: {
            field: 'fkEmpresa',
            type: DataTypes.INTEGER,
            allowNull: false,
                references: {
                    model: 'Computador',
                    key: 'idComputador'
                }
        }
	}, 
	{
		tableName: 'LeituraHardware', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Leitura;
};
