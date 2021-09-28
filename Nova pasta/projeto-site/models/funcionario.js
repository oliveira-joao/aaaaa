'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Funcionario = sequelize.define('Funcionario',{
		idFuncionario: {
			field: 'idFuncionario',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},		
		nomeFuncionario: {
			field: 'nomeFuncionario',
			type: DataTypes.STRING,
			allowNull: false
		},
		loginFuncionario: {
			field: 'loginFuncionario',
			type: DataTypes.STRING,
			allowNull: false
		},
		senhaFuncionario: {
			field: 'senhaFuncionario',
			type: DataTypes.STRING,
			allowNull: false
		},
		emailFuncionario: {
			field: 'emailFuncionario',
			type: DataTypes.STRING,
			allowNull: false
		},
		telefoneFuncionario: {
			field: 'telefoneFuncionario',
			type: DataTypes.STRING,
			allowNull: false
		},
		permissaoAdmin: {
			field: 'permissaoAdmin',
			type: DataTypes.INTEGER,
			allowNull: false
		},
		tipoFuncionario: {
			field: 'tipoFuncionario',
			type: DataTypes.INTEGER,
			allowNull: false
		},
        fkEmpresa: {
            field: 'fkEmpresa',
            type: DataTypes.INTEGER,
            allowNull: false,
                references: {
                    model: 'Empresa',
                    key: 'idEmpresa'
                }
        }
	}, 
	{
		tableName: 'Funcionario', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Funcionario;
};
