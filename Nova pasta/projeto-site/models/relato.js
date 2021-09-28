'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Relato = sequelize.define('Relato',{
		idRelato: {
			field: 'idRelato',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},		
		relatorio: {
			field: 'relatorio',
			type: DataTypes.STRING,
			allowNull: false
		},
		sentimento: {
			field: 'sentimento',
			type: DataTypes.STRING,
			allowNull: false
		},
		momentoRelato: {
			field: 'momentoRelato',
			type: DataTypes.DATE,
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
		tableName: 'Relato', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Relato;
};
