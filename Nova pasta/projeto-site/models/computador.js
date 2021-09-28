'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Computador = sequelize.define('Computador',{
		idComputador: {
			field: 'idFuncionario',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},		
		modelo: {
			field: 'modelo',
			type: DataTypes.STRING,
			allowNull: false
		},
		marca: {
			field: 'marca',
			type: DataTypes.STRING,
			allowNull: false
		},
		nomeCPU: {
			field: 'nomeCPU',
			type: DataTypes.STRING,
			allowNull: false
		},
		totalRAM: {
			field: 'totalRAM',
			type: DataTypes.DOUBLE,
			allowNull: false
		},
		modeloDisco: {
			field: 'modeloDisco',
			type: DataTypes.STRING,
			allowNull: false
		},
		totalDisco: {
			field: 'totalDisco',
			type: DataTypes.DOUBLE,
			allowNull: false
		},
		sistemaOperacional: {
			field: 'sistemaOperacional',
			type: DataTypes.STRING,
			allowNull: false
		},
        fkFuncionario: {
            field: 'fkFuncionario',
            type: DataTypes.INTEGER,
            allowNull: false,
                references: {
                    model: 'Funcionario',
                    key: 'idFuncionario'
                }
        }
	}, 
	{
		tableName: 'Computador', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Computador;
};
